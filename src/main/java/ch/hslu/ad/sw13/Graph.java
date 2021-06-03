package ch.hslu.ad.sw13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
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
    Set<Integer> visited;
    PriorityQueue<Node> pqueue;

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

    int noOfNodes;

    String[][] result;

    public Graph() {
        noOfNodes = adj[0].length;
        visited = new HashSet<Integer>();
        result = new String[noOfNodes + 1][noOfNodes + 1];

    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.init();
        g.resultTableInit();
        g.print();

    }

    public void shortest(int a) {
        int[] label = new int[noOfNodes];
        int resultColumnCount = 2;

        // first add source vertex to PriorityQueue 
        // pqueue.add(new Node("a", Integer.MAX_VALUE));
        label[a] = 0;
        while (visited.size() != noOfNodes) {
          //  int u = pqueue.remove().node;

            // add node to finalized list (visited)
          //  visited.add(u);
        }
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

    public void shortestPath(int a) {
        int[] label = new int[noOfNodes];
        int resultColumnCount = 2;
        Arrays.fill(label, Integer.MAX_VALUE);
        label[a] = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < noOfNodes; i++) { // 
            if (adj[a][i] != 0) { // wenn i ein Nachbar ist
//                    if (label[i] > label[a] + adj[a][i]) {
//                        label[i] = label[a] + adj[a][i];
//                    }
                queue.add(i);

            }
        }

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
            Node node = new Node(alpha[i], Integer.MAX_VALUE);
            Set<Node> set = new HashSet<>();

            for (int j = 0; j < noOfNodes; j++) {
                if (adj[i][j] != 0) {
                    set.add(new Node(alpha[j], adj[i][j])); // the Labels are the distances from the main Node. Alpha is the Letter. 
                }
            }
            map.put(node, set);
        }
    }

    public static int indexOf(int[] arr, int val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }

}
