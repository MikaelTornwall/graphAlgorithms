package algorithms.graphtraversal;

import java.util.*;

public class DepthFirstSearch {
    
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
    
    public void dfs(int u) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        System.out.print(u + " ");
        for (Integer v : adjacencyList[u]) {
            dfs(v);
        }
    }    
    
    public void printPath(int n, int[] from, int[] to) {        
        init(n, from, to);       
        
        System.out.print("Depth-First Search: ");
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println("");
    }
}
