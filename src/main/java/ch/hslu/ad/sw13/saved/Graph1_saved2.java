package ch.hslu.ad.sw13.saved;

import SW13.RailwayNet3;
import ch.hslu.ad.sw13.PrettyPrinter;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
// Produce a table:
//  the shortest path form a given vertex A to all other vertexes. 
public class Graph1_saved2 {
    
 
    private static final Logger LOG = LogManager.getFormatterLogger(Graph1_saved2.class);

    String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
    int[][] adj = {
        //a  b  c  d  e  f  g

        {0, 1, 2, 2, 0, 0, 0}, // a
        {1, 0, 0, 3, 0, 0, 6}, // b
        {2, 0, 0, 1, 1, 0, 0}, // c
        {2, 3, 1, 0, 0, 1, 0}, // d
        {0, 0, 1, 0, 0, 3, 0}, // e
        {0, 0, 0, 1, 3, 0, 3}, // f
        {0, 6, 0, 0, 0, 3, 0}};// g

    int noOfNodes = adj[0].length;
    boolean[] visited = new boolean[noOfNodes];
    String[][] result = new String[noOfNodes + 1][noOfNodes + 1];

    public String[][] getResult() {
        return result;
    }

    void tabelleInitialisiern() {
        for (int i = 0; i < result.length; i++) { // Zeile zuunterst
            if (i == 0) {
                result[result.length - 1][i] = "S";
            } else {
                result[result.length - 1][i] = alpha[i - 1];
            }
        }
        for (int i = 0; i < result.length - 1; i++) { // iterieren über y
            if (i == 0) {
                // result[i][0] = String.format("L(%s)", alpha[i]); 
                // this is variable
            }
            result[i][0] = String.format("L(%s) | p(%s)", alpha[i], alpha[i]);
        }
        for (int i = 1; i < result[0].length - 1; i++) {
            result[i][1] = "inf";
        }
    }

    void diagonaleSpiegeln() {
        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                if (adj[i][j] != 0) {
                    if (adj[j][i] == 0) {
                        adj[j][i] = adj[i][j];
                    }
                } else if (adj[j][i] != 0) {
                    if (adj[i][j] == 0) {
                        adj[i][j] = adj[j][i];
                    }
                }
            }
        }
    }

    public void shortestPath(int a) { // a ist der Index des elements, von dem aus wir suchen.
        int[] label = new int[noOfNodes]; // label is the path from A to A B C D E F G ...
        int resultColumnCount = 2; // Spalte die gefüllt werden muss
        Arrays.fill(label, Integer.MAX_VALUE); // alle labels ohne A auf unendlich 
        label[a] = 0; // A zu sich selber ist irrelevant

        
        // I need to make a queue of all the nodes, so I can remove the ones which I already visit. 
        while (!allVisited(visited)) {
            //Jetzt alle Nachbarn von a anschauenn. 
            for (int i = 0; i < noOfNodes; i++) { // alle Nachbarn vom start Knoten.  
                if (adj[a][i] != 0) { // wenn i ein Nachbar ist
                    if (label[i] > label[a] + adj[a][i]) {
                        label[i] = label[a] + adj[a][i];
                    }
                }
            }
            visited[a] = true;

            // hier Tabelle füllen
            for (int i = 0; i < result.length - 2; i++) {
                if (!visited[i]) { // only make entry for tables we not already visited
                    String tableEntry;
                    if (label[i] == 0) {

                    }
                    if (label[i] == Integer.MAX_VALUE) {
                        tableEntry = "inf";
                    } else {
                        tableEntry = String.valueOf(label[i]) + " | " + alpha[a];
                    }
                    System.out.println("resultColumnCount = " + resultColumnCount);
                    result[i][resultColumnCount] = tableEntry;
                }
            }

            // wenn das Minimum aus mehreren besteht, was dann? . 
            int minLabel = getMinOfLabel(label, a);
            int minLabelIndex = indexOf(label, minLabel);

            a = minLabelIndex; // jump to the next Vertex, ( = Minima of all Edges) -> here I'm not sure if we only have to consider one or more?

            if (resultColumnCount == noOfNodes) {
                return; // not very elegant
            }
            resultColumnCount++;
        }

    }

    // little helper function to see if we visited all nodes. 
    public static boolean allVisited(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public int getMinOfLabel(final int[] label, final int a) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < label.length; i++) {
            // only return neighbours. From those, it can't return itself as min, and it can't return already visited nodes as min.
            if (i != a && adj[a][i] != 0 && visited[i] == false) {  // only search neighbour lables 
                if (label[i] < min) {
                    min = label[i];
                    count += 1;
                }
            }
        }

        if (count == 0) {
            LOG.error("getMinOfLabel: Somethings wrong. Never reached a better Min");
        }
        return min;
    }

    public int Dijkstra(final int s, final int z) {

        boolean[] setT = new boolean[noOfNodes];
        Arrays.fill(setT, false);

        setT[s] = true;
        int[] minEntf = new int[noOfNodes];
        minEntf[s] = 0;
        while (!setT[z]) {
            int min = Integer.MAX_VALUE;
            int kNeu = 0;
            for (int k = 0; k < noOfNodes; k++) {
                if (setT[k]) {
                    for (int nk = 0; nk < noOfNodes; nk++) {
                        if (!setT[nk] && (adj[k][nk] < Integer.MAX_VALUE)) {
                            int kNeuEntf = minEntf[k] + adj[k][nk];
                            if (kNeuEntf < min) {
                                min = kNeuEntf;
                                kNeu = nk;
                            }
                        }
                    }
                }
            }
            setT[kNeu] = true;  //   kNeu wird in T aufgenommen 
            minEntf[kNeu] = min;
        }

        return minEntf[z];

    }

    void print() {
        for (int[] x : adj) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    void prettyPrint() {
        final PrettyPrinter printer = new PrettyPrinter(System.out);
        printer.print(result);
    }

    public static int indexOf(int[] arr, int val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        Graph1_saved2 g = new Graph1_saved2();
        g.diagonaleSpiegeln();
        g.tabelleInitialisiern();
        g.shortestPath(0);
        g.prettyPrint();

    }

}
