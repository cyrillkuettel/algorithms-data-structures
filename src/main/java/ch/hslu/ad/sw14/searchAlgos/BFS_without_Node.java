package ch.hslu.ad.sw14.searchAlgos;
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.*;
// This class represents a directed graph using adjacency list
// representation

public final class BFS_without_Node {
    private int V; // number of fertices

    private final LinkedList<Integer>[] adj;
    private final boolean[] visited;

    public BFS_without_Node(int v) {
        V = v;
        visited = new boolean[V];
        adj = new LinkedList[V];

        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList();
        }
    }


    // prints BFS traversal from a given source s
    public void BFS(int start) {
        // procedure.
        // put neighbours in Queue. Use LinkedListImplemenation
        // visited...

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            start = queue.poll();
            System.out.print(start + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> it = adj[start].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

        // Function to add an edge into the graph
        public void addEdge(int v, int w){
            adj[v].add(w);
        }

        // Driver method to
        public static void main (String args[])
        {
            BFS_without_Node g = new BFS_without_Node(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Following is Breadth First Traversal " +
                    "(starting from vertex 2)");

            g.BFS(2);
        }


    }
