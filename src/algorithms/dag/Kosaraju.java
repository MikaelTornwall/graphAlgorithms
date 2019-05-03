package algorithms.dag;

import java.util.*;

public class Kosaraju {
   
    List<List<Integer>> components = new ArrayList<>();
    List<Integer> component = new ArrayList<>();    
    ArrayDeque<Integer> order = new ArrayDeque<>();    
    ArrayList<Integer>[] adjacencyList;
    ArrayList<Integer>[] transposeList;    
    ArrayList<Integer>[] helper;
    String[] status;
    boolean secondRound = false;
    
    public void init(int n, int[] from, int[] to) {
        initColor(n);
        
        adjacencyList = new ArrayList[n + 1];
        transposeList = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            transposeList[i] = new ArrayList<>();                
        }                
        
        for (int i = 0; i < from.length; i++) {
            adjacencyList[from[i]].add(to[i]);
            transposeList[to[i]].add(from[i]);
        }        
    }
    
    public void initColor(int n) {
        status = new String[n + 1];
        
         for (int i = 1; i <= n; i++) {            
            status[i] = "white";           
        }      
    }
    
    public void bfs(int u) {
        status[u] = "gray";
        
        for (Integer v : helper[u]) {
            if (status[v] == "gray" && secondRound) {                
                component = new ArrayList<>();
            } else if (status[v] == "white") {
                bfs(v);
            }
        }
        
        status[u] = "black";
        order.addFirst(u);
        
        if (secondRound) {            
            component.add(u);
        }
        
    }
    
    public List<List<Integer>> components(int n, int[] from, int[] to) {
        
        init(n, from, to);        
        
        helper = adjacencyList;
        
        for (int i = 1; i < n; i++) {
            if (status[i] != "black") {
                bfs(i);
            }
        }
        
        helper = transposeList;
        initColor(n);
        secondRound = true;                
        
        while (!order.isEmpty()) {
            if (status[order.peekFirst()] == "white") {                                
                bfs(order.poll());
                components.add(component);
            } else {
                order.poll();
            }                        
        }
        
        return components;
    }
    
}
