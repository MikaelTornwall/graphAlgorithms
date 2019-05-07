package algorithms.spanningtrees;

import algorithms.spanningtrees.domain.Node;
import algorithms.spanningtrees.domain.Edge;

import java.util.*;

public class Prim {
    
    ArrayList<Node>[] adjacencyList;
    boolean[] included;
    
    public void init(int n, int[] from, int[] to, int[] weight) {
        
        adjacencyList = new ArrayList[n + 1];
        included = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            included[i] = false;
        }
        
        for (int i = 0; i < from.length; i++) {
            adjacencyList[from[i]].add(new Node(to[i], weight[i]));
            adjacencyList[to[i]].add(new Node(from[i], weight[i]));
        }        
    } 
    
    public ArrayList<Edge> Prim(int a) {
        
        ArrayList<Edge> edges = new ArrayList<>();              
        
        included[a] = true;
        
        PriorityQueue<Edge> heap = new PriorityQueue();
        
        for (Node edge : adjacencyList[a]) {
            heap.add(new Edge(a, edge.node, edge.weight));
        }
        
        while (!heap.isEmpty()) {
            Edge top = heap.poll();
            int u = top.to;
            
            if (included[u]) continue;
            
            edges.add(top);
            included[u] = true;
            
            for (Node edge : adjacencyList[u]) {
                if (!included[edge.node]) heap.add(new Edge(u, edge.node, edge.weight));
            }
        }
        
        return edges;
    }
    
    public ArrayList<Edge> minimumSpanningTree(int n, int[] from, int[] to, int[] weight) {
        init(n, from, to, weight);
        
        return Prim(from[0]);
    }
}
