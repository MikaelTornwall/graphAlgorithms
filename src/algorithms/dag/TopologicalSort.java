package algorithms.dag;

import java.util.*;
import java.util.Collections;

public class TopologicalSort {
    
    List<Integer> order = new ArrayList<>();
    ArrayList<Integer>[] adjacencyList;
    String[] status;
    
    boolean cycle = false;
    
    public void init(int n) {        
        adjacencyList = new ArrayList[n + 1];
        status = new String[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            status[i] = "white";
        }        
    }
    
    public void generateAdjacencyList(int n, int[] from, int[] to) {
        
        for (int i = 0; i < n; i++) {
            adjacencyList[from[i]].add(to[i]);
        }
    }
    
    public void bfs(int u) {
        status[u] = "gray";
        
        for (Integer v : adjacencyList[u]) {
            if (status[v] == "gray") {
                cycle = true;
                return;
            } else if (status[v] == "white") {
                bfs(v);
            }            
        }
        status[u] = "black";
        order.add(u);
    }
    
    public List<Integer> order(int n, int[] from, int[] to) {     
        
        init(n);
        generateAdjacencyList(n, from, to);
        
        for (int i = 1; i <= n; i++) {
            if (status[i] == "white") {
                bfs(i);
            }
        }        
        
        if (cycle) {
            return new ArrayList<>();
        }
        
        return order;
    }
}
