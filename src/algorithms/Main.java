package algorithms;

import algorithms.graphtraversal.DepthFirstSearch;
import algorithms.graphtraversal.BreadthFirstSearch;
import algorithms.shortestpath.BellmanFord;
import algorithms.shortestpath.Dijkstra;
import algorithms.dag.TopologicalSort;
import algorithms.dag.Kosaraju;
import algorithms.dag.LongestPath;
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
        
        // Unweighted graphs - Graph traversal
        
        // Depth-First Search (DFS)
        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.printPath(5, new int[]{1, 1, 2, 2, 4}, new int[]{2, 3, 4, 5, 5});
        
        // Breadth-First Search (BFS)
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.printPath(5, new int[]{1, 1, 2, 2, 4}, new int[]{2, 3, 4, 5, 5});
        
        // Weighted graphs
        
        // Shortest Paths
        
        // Bellman-Ford algorithm
        // Finds the shortest path, time complexity O(mn)
        BellmanFord bellmanFord = new BellmanFord();
        
        // Dijkstra's algorithm
        // Finds the shortest path, time complexity O(n + m log n)
        Dijkstra dijkstra = new Dijkstra();                
        
        System.out.println("Bellman-Ford: " + bellmanFord.shortestPath(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}));
        System.out.println("Dijkstra: " + dijkstra.shortestPath(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}));
        
        // Directed Acyclic Graphs (DAG)
        
        // Topological Sort
        // Prints one topological order of the graph, time complexity O(n + m)
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> order = topologicalSort.order(5, new int[]{1, 2, 1, 3, 3, 5}, new int[]{2, 4, 3, 2, 4, 4});
        
        if (order.isEmpty()) {
            System.out.println("Cycle found. Topological order does not exist.");
        } else {
            System.out.print("Topological sort: ");
            for (int i = order.size() - 1; i >= 0; i--) {
                System.out.print(order.get(i) + " ");
            }
            System.out.println();
        }
        
        // Kosaraju's algorithm
        // Prints the strongly connected components of the graph, time complexity O(n + m)
        Kosaraju kosaraju = new Kosaraju();
        List<List<Integer>> components = kosaraju.components(6, new int[]{1, 2, 3, 3, 3, 4, 4, 5, 6}, new int[]{3, 1, 2, 4, 5, 2, 6, 6, 5});
        System.out.println("Kosaraju, strongly connected components: " + components);
        
        // Longest path in DAG
        LongestPath longestPath = new LongestPath();
        int length = longestPath.getLength(7, new int[]{1, 1, 2, 3, 4, 4, 5, 6}, new int[]{2, 4, 3, 7, 3, 5, 6, 3});
        System.out.println("Longest path: " + length);
        
    }
    
}
