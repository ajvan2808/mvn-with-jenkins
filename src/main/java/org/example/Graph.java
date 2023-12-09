package org.example;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * breadthFirstSearch (Graph data structure)
 */
public class Graph {
    private int V;  // No. of vertices: stt cuar các đỉnh lân cận
    private LinkedList<Integer> adj[];  // Adjacency list 


    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w); 
    }

    // BFS from a given source
    public void breadthFirstSearch(int s) {
        // Mark all vertices as not visited (false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark current node as visited and enqueue it
        visited[s] = true;
        System.out.println("Starting at: " + s);
        queue.add(s);

        while(queue.size() != 0) {
            // De-queue a vertex from queue and print it
            s = queue.poll();
            System.out.println("De-queueing: " + s);

            // Get all adjacent vertices of the de-queue vertex s
            // If an adjacent hasn't visited, mark it visited and en-queue
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if( !visited[n] ) {
                    visited[n] = true;
                    System.out.println("Queueing: " + n);
                    queue.add(n);
                }
            }
        }
    }

    // DEPTH FIRST SEARCH
    public void DFS(int vertex) {
        boolean marked[] = new boolean[V];

        Stack<Integer> stack = new Stack<Integer>();
        stack.add(vertex);

        marked[vertex] = true;
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println("Popping " + current);

            Iterator<Integer> y = adj[current].listIterator();
            while (y.hasNext()) {
                int m = y.next();
                if (!marked[m]) {
                    stack.add(m);
                    marked[m] = true;
                    System.out.println("Pushing - " + m);
                }
            }
        }
    }
}