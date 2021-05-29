package ch.hslu.ad.sw13;

import SW13.RailwayNet3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cyrill
 */
// Produce a table:
//  the shortest path form a given vertex A to all other vertexes. 
public class Graph {

    private static final Logger LOG = LogManager.getFormatterLogger(Graph.class);

    Map<Node, Set<Node>> map = new HashMap<>();
    static String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
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

    public static void main(String[] args) {
        System.out.println(alpha[0]);
        Graph g = new Graph();
        g.init();
        g.resultTableInit();
        g.print();
        g.printMap();

//        g.shortestPath(0);
//        g.prettyPrint();
    }

    public void resultTableInit() {
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

    public void init() {
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
        // Init the Nodes
        for (int i = 0; i < noOfNodes; i++) {
            Node node = new Node(Integer.MAX_VALUE, alpha[i]);
            Set<Node> set = new HashSet<>();

            for (int j = 0; j < noOfNodes; j++) {
                if (adj[i][j] != 0) {
                    set.add(new Node(adj[i][j], alpha[j])); // the Labels are the distances from the main Node. Alpha is the Letter. 
                }
            }
            map.put(node, set);
        }
    }

    public void shortest(int a) {
        int[] label = new int[noOfNodes];
        int resultColumnCount = 2;
        Queue<Node> queue = new LinkedList<>(); // FIfO Queue
        //queue.add(map.get(new Node(Integer.MAX_VALUE, "a")));
        

    }

    public void shortestPath(int a) { // a ist der Index des elements, von dem aus wir suchen.
        int[] label = new int[noOfNodes]; // label is the path from A to A B C D E F G ...
        int resultColumnCount = 2; // Spalte die gefüllt werden muss
        Arrays.fill(label, Integer.MAX_VALUE); // alle labels ohne A auf unendlich 
        label[a] = 0; // A zu sich selber ist irrelevant
        Queue<Integer> queue = new LinkedList<>(); // FIfO Queue

        while (!allVisited()) {
            //Jetzt alle Nachbarn von a anschauenn. 
            for (int i = 0; i < noOfNodes; i++) { // alle Nachbarn vom start Knoten.  
                if (adj[a][i] != 0) { // wenn i ein Nachbar ist
//                    if (label[i] > label[a] + adj[a][i]) {
//                        label[i] = label[a] + adj[a][i];
//                    }
                    queue.add(i);

                }
            }
            int element = queue.remove();

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
    public boolean allVisited() {
        for (boolean b : visited) {
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

    public void printMap() {
        Iterator<Map.Entry<Node, Set<Node>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Node, Set<Node>> pair = it.next();

            Node key = pair.getKey();
            Set<Node> value = pair.getValue();
            System.out.println(key);
            int count = 0;
            for (Node node : value) {
                if (count == 0) {
                    System.out.println("      " + node.toString());
                } else {
                    System.out.println(" , " + node.toString());
                }
            }
            System.out.println();
        }

    }

    public static int indexOf(int[] arr, int val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }

}
