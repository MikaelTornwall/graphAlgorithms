package algorithms.shortestpath.domain;

public class Edge {
    
    public int beginning;
    public int end;
    public long weight;
    
    public Edge(int beginning, int end, long weight) {
        this.beginning = beginning;
        this.end = end;
        this.weight = weight;
    }
}
