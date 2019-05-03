package algorithms.shortestpath;

import algorithms.shortestpath.domain.Edge;
import java.util.*;

public class BellmanFord {
    
    ArrayList<Edge> edges = new ArrayList<>();
    long[] distances;
    
    public void generateEdge(int from, int to, long weight) {
        Edge kaari = new Edge(from, to, weight);
        edges.add(kaari);
    }
    
    public void initDistances(int n) {
        this.distances = new long[n + 1];
        
        for (int i = 1; i <= n; i++) {
            this.distances[i] = 999999999;            
        }               
    }
    
    public long bellmanFord(int n, int u) {
                
        distances[u] = 0;        
        
        for (int i = 1; i <= n; i++) {
            for (Edge kaari : edges) {                
                long curr = distances[kaari.end];
                long next = distances[kaari.beginning] + kaari.weight;                
                if (next < curr) {
                    distances[kaari.end] = next;
                }
            }
        }
        
        return this.distances[n];
    }
    
    public long shortestPath(int n, int[] from, int[] to, long[] weight) {                
        
        initDistances(n);                
        
        for (int i = 0; i < n; i++) {
            generateEdge(from[i], to[i], weight[i]);
        }                
        
        return bellmanFord(n, 1);
    }
}
