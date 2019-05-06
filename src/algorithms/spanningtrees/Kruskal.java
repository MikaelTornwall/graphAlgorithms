package algorithms.spanningtrees;

import java.util.*;
import algorithms.spanningtrees.domain.Edge;

public class Kruskal {
    
    ArrayList<Edge> edgeList = new ArrayList<>();
    
    int[] parent;
    int[] size;
    
    // Union-find data structure
    public void makeSet(int x) {
        parent[x] = x;
        size[x] = 1;
    }
    
    public void union(int x, int y) {
        if (size[x] > size[y]) {
            parent[y] = x;
            size[x] = size[x] + size[y];
        } else {
            parent[x] = y;
            size[y] = size[y] + size[x];
        }
    }
    
    public int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        
        return x;
    }   
    
    public void init(int n, int[] from, int[] to, int[] weights) {
        
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for (int i = 0; i < from.length; i++) {
            edgeList.add(new Edge(from[i], to[i], weights[i]));              
        }        
    }
    
    public ArrayList<Edge> kruskal(int n) {
        ArrayList<Edge> mst = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            this.makeSet(i);
        }
        
        Collections.sort(this.edgeList);
        
        for (Edge edge : edgeList) {
            int a = find(edge.from);
            int b = find(edge.to);
            
            if (a != b) {
                union(a, b);
                mst.add(edge);
            }
        }
        
        return mst;        
    }
    
    public ArrayList<Edge> minimumSpanningTree(int n, int[] from, int[] to, int[] weights) {
        init(n, from, to, weights);
        
        return kruskal(n);
    }
}
