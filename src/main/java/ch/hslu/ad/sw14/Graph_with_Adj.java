package ch.hslu.ad.sw14;

/**
 *
 * @author cyrill
 */
import ch.hslu.ad.sw13.PrettyPrinter;
import java.lang.*;

class Graph_with_Adj {

    String[][] result = new String[NUM_VERTICES + 1][NUM_VERTICES + 1];
   public static final String[] alpha = {"a", "b", "c", "d", "e", "f", "g"};
    /*
    // wenn man Tabelle ausfüllt: Zuerst alles mit Null füllen. Geht einfacher. 
   // alpha anpassen, wenn man adj[][] anpasst.
   // Vorgäner P(c) manuell bestimmen: Alles was von a weggeht, ist Vorgäner von a
    // wenn nicht von a weggeht: dort wo es zum ersten mal Auftaucht, vorgänger ist das vorherige S
   
   // wichtig: Wenn sich die zahl ändert (zum Beispiel L(b) ) dann ändert sich der Vorgänger auch.
   
    int[][] adj = {
       //a  b  c  d  e  f  g  h     // if neccessary expand this to the task given at hand

        {0, 0, 0, 0, 0, 0, 0, 0}, // a
        {0, 0, 0, 0, 0, 0, 0, 0}, // b
        {0, 0, 0, 0, 0, 0, 0, 0}, // c
        {0, 0, 0, 0, 0, 0, 0, 0}, // d
        {0, 0, 0, 0, 0, 0, 0, 0}, // e
        {0, 0, 0, 0, 0, 0, 0, 0}, // f
        {0, 0, 0, 0, 0, 0, 0, 0},// g
        {0, 0, 0, 0, 0, 0, 0, 0 }}; //h

    */
    
    
            int[][] adj = {
        //a  b  c  d  e  f  g       // if neccessary expand this to the task given at hand

        {0, 1, 2, 2, 0, 0, 0}, // a
        {1, 0, 0, 3, 0, 0, 6}, // b
        {2, 0, 0, 1, 1, 0, 0}, // c
        {2, 3, 1, 0, 0, 1, 0}, // d
        {0, 0, 1, 0, 0, 3, 0}, // e
        {0, 0, 0, 1, 3, 0, 3}, // f
        {0, 6, 0, 0, 0, 3, 0}};// g

    public static final int NUM_VERTICES = alpha.length;  // max number of vertices in graph  
    // find a vertex with minimum distance

    int minDistance(int path_array[], Boolean sptSet[]) {
        // Initialize min value 
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < NUM_VERTICES; v++) {
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
        for (int i = 0; i < NUM_VERTICES; i++) {
            System.out.println(i + " \t\t\t " + path_array[i]);
        }
    }

// Implementation of Dijkstra's algorithm for graph (adjacency matrix) 
    void algo_dijkstra(int src_node) {
    
        int path_array[] = new int[NUM_VERTICES]; // The output array. dist[i] will hold the shortest distance from src to i 

        // spt (shortest path set) contains vertices that have shortest path 
        Boolean sptSet[] = new Boolean[NUM_VERTICES];

        // Initially all the distances are INFINITE and stpSet[] is set to false 
        for (int i = 0; i < NUM_VERTICES; i++) {
            path_array[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Path between vertex and itself is always 0 
        path_array[src_node] = 0;
        // now find shortest path for all vertices  
        for (int count = 0; count < NUM_VERTICES - 1; count++) {
            // call minDistance method to find the vertex with min distance
            int u = minDistance(path_array, sptSet);
            System.out.println("currently processsing " + alpha[u]);
            // the current vertex u is processed
            sptSet[u] = true;
            // process adjacent nodes of the current vertex
            for (int v = 0; v < NUM_VERTICES; v++) // if vertex v not in sptset then update it  
            {
                if (!sptSet[v] && adj[u][v] != 0 && path_array[u]
                        != Integer.MAX_VALUE && path_array[u]
                        + adj[u][v] < path_array[v]) {
                    path_array[v] = path_array[u] + adj[u][v];
                }
            }

            if (count < (NUM_VERTICES - 2)) {
                int i;
                for ( i = 0; i < path_array.length; i++) {
                    if (path_array[i] == Integer.MAX_VALUE) {
                        result[i][count + 2] = "inf";
                    } else {

                        result[i][count + 2] = String.valueOf(path_array[i]);
                    }
                }
                
                result[i][count + 1]  = alpha[u] + "   "; // unten Hinschreiben
            }

        }

        // print the path array 
        //printMinpath(path_array);
        
    }

    void tabelleInitialisiern() {
        for (int i = 0; i < result.length; i++) { // Zeile zuunterst
            if (i == 0) {
                result[result.length - 1][i] = "S";
            }
        }
        for (int i = 0; i < result.length - 1; i++) { // iterieren über y
            result[i][0] = String.format("L(%s)", alpha[i]);
        }
        for (int i = 1; i < result[0].length - 1; i++) {
            result[i][1] = "inf";
        }
    }

    void diagonaleSpiegeln() {
        for (int i = 0; i < NUM_VERTICES; i++) {
            for (int j = 0; j < NUM_VERTICES; j++) {
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
        g.algo_dijkstra(0);
        g.prettyPrint();

    }
}
