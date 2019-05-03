package algorithms.dag;

import java.util.*;

public class LongestPath {
    
    ArrayList<Integer>[] adjacencyList;
    String[] status;
    Integer[] distances;    
    Integer[] followers;
    
    public void init(int n, int[] from, int[] to) {
        adjacencyList = new ArrayList[n + 1];
        status = new String[n + 1];
        distances = new Integer[n + 1];
        followers = new Integer[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            status[i] = "white";            
        }
        
        for (int i = 0; i < from.length; i++) {
            adjacencyList[from[i]].add(to[i]);
        }
    }
    
    public void bfs(int u) {
        status[u] = "gray";
        distances[u] = 0;
        followers[u] = null;
        
        for (Integer v : adjacencyList[u]) {
            if (status[v] == "gray") {
                System.out.println("Error: Cycle found");
                return;
            } else if (status[v] == "white") {
                bfs(v);
            }
            int next = distances[v] + 1;            
            if (next > distances[u]) {
                distances[u] = next;
                followers[u] = v;
            }
        }
        status[u] = "black";
    }
    
    public int getLength(int n, int[] from, int[] to) {
        init(n, from, to);
        
        for (int i = 1; i <= n; i++) {
            if (status[i] == "white") {
                bfs(i);
            }
        }
                
        return distances[1];
    }
}
