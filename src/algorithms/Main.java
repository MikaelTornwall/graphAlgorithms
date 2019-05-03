package algorithms;

import algorithms.dag.TopologicalSort;
import algorithms.shortestpath.Dijkstra;
import algorithms.shortestpath.BellmanFord;
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
        
        // Weighted graphs
        
        // Shortest Paths
        BellmanFord bellmanFord = new BellmanFord();
        
        Dijkstra dijkstra = new Dijkstra();                
        
        System.out.println(bellmanFord.shortestPath(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}));
        System.out.println(dijkstra.shortestPath(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}));
        
        // Directed Acyclic Graphs (DAG)
        
        // Topological Sort
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> order = topologicalSort.order(5, new int[]{1, 2, 1, 3, 3, 5}, new int[]{2, 4, 3, 2, 4, 4});
        
        if (order.isEmpty()) {
            System.out.println("Cycle found. Topological order does not exist.");
        } else {
            for (int i = order.size() - 1; i >= 0; i--) {
                System.out.print(order.get(i) + " ");
            }
        }
    }
    
}
