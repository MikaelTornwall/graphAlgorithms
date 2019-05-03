package algorithms.graphtraversal;

import java.util.*;

public class BreadthFirstSearch {
    
    ArrayList<Integer>[] adjacencyList;
    
    boolean[] visited;
    
    public void init(int n, int[] from, int[] to) {
        adjacencyList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            visited[i] = false;
        }
        
        for (int i = 0; i < from.length; i++) {
            adjacencyList[from[i]].add(to[i]);
            adjacencyList[to[i]].add(from[i]);
        }
    }
    
    public void bfs(int u) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(u);
        visited[u] = true;        
        while (!queue.isEmpty()) {            
            u = queue.poll();
            System.out.print(u + " ");
            for (Integer v : adjacencyList[u]) {
                if (visited[v]) continue;
                queue.add(v);
                visited[v] = true;
            }
        }
    }
    
     public void printPath(int n, int[] from, int[] to) {        
        init(n, from, to);       
                
        System.out.print("Breadth-First Search: ");
        bfs(from[0]);
        System.out.println("");
     }     
        
}
