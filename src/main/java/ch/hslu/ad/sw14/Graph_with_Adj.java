package ch.hslu.ad.sw14;

/**
 *
 * @author cyrill
 */
import ch.hslu.ad.sw13.PrettyPrinter;
import java.util.*;
import java.lang.*;

class Graph_with_Adj {

    String[][] result = new String[num_Vertices + 1][num_Vertices + 1];
    String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
    int[][] adj = {
        //a  b  c  d  e  f  g       // if neccessary expand this to the task given at hand

        {0, 1, 2, 2, 0, 0, 0}, // a
        {1, 0, 0, 3, 0, 0, 6}, // b
        {2, 0, 0, 1, 1, 0, 0}, // c
        {2, 3, 1, 0, 0, 1, 0}, // d
        {0, 0, 1, 0, 0, 3, 0}, // e
        {0, 0, 0, 1, 3, 0, 3}, // f
        {0, 6, 0, 0, 0, 3, 0}};// g

    static final int num_Vertices = 7;  // max number of vertices in graph  
    // find a vertex with minimum distance

    int minDistance(int path_array[], Boolean sptSet[]) {
        // Initialize min value 
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < num_Vertices; v++) {
            if (sptSet[v] == false && path_array[v] <= min) {
                min = path_array[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // print the array of distances (path_array)
    void printMinpath(int path_array[]) {
        System.out.println("Vertex# \t Minimum Distance from Source");
        for (int i = 0; i < num_Vertices; i++) {
            System.out.println(i + " \t\t\t " + path_array[i]);
        }
    }

// Implementation of Dijkstra's algorithm for graph (adjacency matrix) 
    void algo_dijkstra(int src_node) {
        int path_array[] = new int[num_Vertices]; // The output array. dist[i] will hold the shortest distance from src to i 

        // spt (shortest path set) contains vertices that have shortest path 
        Boolean sptSet[] = new Boolean[num_Vertices];

        // Initially all the distances are INFINITE and stpSet[] is set to false 
        for (int i = 0; i < num_Vertices; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Path between vertex and itself is always 0 
        path_array[src_node] = 0;
        // now find shortest path for all vertices  
        for (int count = 0; count < num_Vertices - 1; count++) {
            // call minDistance method to find the vertex with min distance
            int u = minDistance(path_array, sptSet);
            // the current vertex u is processed
            sptSet[u] = true;
            // process adjacent nodes of the current vertex
            for (int v = 0; v < num_Vertices; v++) // if vertex v not in sptset then update it  
            {
                if (!sptSet[v] && adj[u][v] != 0 && path_array[u]
                    != Integer.MAX_VALUE && path_array[u]
                    + adj[u][v] < path_array[v]) {
                    path_array[v] = path_array[u] + adj[u][v];
                }
            }
            System.out.println(Arrays.toString(path_array));

            if (count < (num_Vertices - 2)) {
                for (int i = 0; i < path_array.length; i++) {
                    if (path_array[i] == Integer.MAX_VALUE) {
                        result[i][count + 2] = "inf";
                    } else {

                        result[i][count + 2] = String.valueOf(path_array[i]);
                    }

                }
            }

        }

        // print the path array 
        printMinpath(path_array);
    }

    void tabelleInitialisiern() {
        for (int i = 0; i < result.length; i++) { // Zeile zuunterst
            if (i == 0) {
                result[result.length - 1][i] = "S";
            } else {
//                result[result.length - 1][i] = alpha[i - 1];
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
        for (int i = 0; i < num_Vertices; i++) {
            for (int j = 0; j < num_Vertices; j++) {
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

    public void prettyPrint() {
        final PrettyPrinter printer = new PrettyPrinter(System.out);
        printer.print(result);
    }

    public String[][] getResult() {
        return result;
    }

    public static void main(String[] args) {
        Graph_with_Adj g = new Graph_with_Adj();
        g.tabelleInitialisiern();
        g.prettyPrint();
        g.algo_dijkstra(0);
        g.prettyPrint();
        
// die Tabelle kann realativ einfach gemacht werden.

// die unterste Zeile kann mittels Deduktion herausgefudnen wernden. 
// Jeweils für ein Feld, die Spalte mit der Nächsten Spalte vergleichen:
// was hat sich verändert.
    }
}
