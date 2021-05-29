package ch.hslu.ad.sw13;

import java.util.Arrays;

/**
 *
 * @author cyrill
 */
// Produce a table:
//  the shortest path form a given vertex A to all other vertexes. 
public class Graph {

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
                result[i][0] = String.format("L(%s)", alpha[i]);
            }
            result[i][0] = String.format("L(%s) | p(%s)", alpha[i], alpha[i]);
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

    public void shortestPath(final int a) { // a ist der Index des elements, von dem aus wir suchen.
        // der kürzeste weg von a zu irgend 
        // einem anderen Knoten
        // zuerst ist die erste Spalte überall unendlich. 

        int[] label = new int[noOfNodes];
        Arrays.fill(label, Integer.MAX_VALUE); // alle labels ohne A auf unendlich 
        label[a] = 0;
        // alle Nachbarn von a anschauenn. 

        for (int i = 0; i < noOfNodes; i++) { // alle Nachbarn vom start Knoten.  
            if (adj[a][i] != 0) {
                if (label[i] > label[a] + adj[a][i]) {
                    label[i] = label[a] + adj[a][i];
                }
            }
            // als nächstes suchen wir ein minimales Label aus den labels

        }

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

    void printResult() {
        for (String[] x : result) {
            for (String y : x) {
                System.out.print(y + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.diagonaleSpiegeln();
        g.tabelleInitialisiern();
        g.printResult();

    }


}
