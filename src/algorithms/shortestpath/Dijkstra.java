package algorithms.shortestpath;

import algorithms.shortestpath.domain.Vertice;
import java.util.*;

public class Dijkstra {

    ArrayList<Vertice>[] adjacencyList;
    long[] distances;
    boolean[] processed;
    
    public void init(int n) {
        this.adjacencyList = new ArrayList[n + 1];
        this.distances = new long[n + 1];
        this.processed = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            this.adjacencyList[i] = new ArrayList<>();
            distances[i] = 999999999;
            processed[i] = false;
        }
    }
    
    public void addNode(int from, int to, long weight) {
        this.adjacencyList[from].add(new Vertice(to, weight));
    }
         
    public long dijkstra(int n, int u) {
        
        PriorityQueue<Vertice> heap = new PriorityQueue<>();
        heap.add(new Vertice(u, 0));   
        distances[u] = 0;
        
        while (!heap.isEmpty()) {
            Vertice vertice = heap.poll();            
            
            if (processed[vertice.node]) {
                continue;
            }
            
            processed[vertice.node] = true;
            
            for (Vertice edge : adjacencyList[vertice.node]) {
                long curr = distances[edge.node];
                long next = distances[vertice.node] + edge.weight;
                if (next < curr) {
                    distances[edge.node] = next;
                    heap.add(new Vertice(edge.node, next));
                }
            }
        }
        
        return distances[n];
    }
    
    public long shortestPath(int n, int[] from, int[] to, long[] distance) {
        
        init(n);
        
        for (int i = 0; i < n; i++) {
            addNode(from[i], to[i], distance[i]);
        }                
                        
        return dijkstra(n, 1);
    }
}
