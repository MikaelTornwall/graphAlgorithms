package algorithms.maximumflow;

import java.util.*;

public class FordFulkerson {
    
    int [][] adjacencyMatrix;
    int[][] residualgraph;
    int[] parents;    
    
    public void init(int n, int[] from, int[] to, int[] weight) {
        
        adjacencyMatrix = new int[n + 1][n + 1];
        residualgraph = new int[n + 1][n + 1];
        parents = new int[n + 1];
        
        for (int i = 0; i < from.length; i++) {
            adjacencyMatrix[from[i]][to[i]] = weight[i];
            residualgraph[from[i]][to[i]] = weight[i];
        }
    }
    
    public boolean bfs(int source, int sink) {
        
        boolean[] visited = new boolean[sink + 1];
        
        for (int i = 1; i < visited.length; i++) {
            visited[i] = false;
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        
        queue.add(source);
        visited[source] = true;
        parents[source] = -1;
        
        while (!queue.isEmpty()) {
            
            int u = queue.poll();
            
            for (int v = 0; v <= sink; v++) {
                if (visited[v] == false && residualgraph[u][v] > 0) {
                    queue.add(v);
                    parents[v] = u;
                    visited[v] = true;
                }
            }
        }
        
        return visited[sink];
    }
    
    public int fordFulkerson(int source, int sink) {
        
        int maximumFlow = 0;
        
        while(bfs(source, sink)) {
            
            int pathFlow = Integer.MAX_VALUE;
            
            for (int v = sink; v != source; v = parents[v]) {
                int u = parents[v];
                pathFlow = Math.min(pathFlow, residualgraph[u][v]);
            }
            
            for (int v = sink; v != source; v = parents[v]) {
                int u = parents[v];
                residualgraph[u][v] -= pathFlow;
                residualgraph[v][u] += pathFlow;
            }
            
            maximumFlow += pathFlow;
        }
        
        return maximumFlow;
    }
    
    public int maximumFlow(int n, int[] from, int[] to, int[] weight) {
        init(n, from, to, weight);
        
        return fordFulkerson(1, n);
    }
}
