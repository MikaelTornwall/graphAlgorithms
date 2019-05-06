package algorithms.spanningtrees.domain;

public class Edge implements Comparable<Edge> {
    
    public int from;
    public int to;
    public int weight;
    
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge another) {
        return this.weight - another.weight;
    }
    
    @Override
    public String toString() {
        return "(" + this.from + ", " + this.to + "): " + this.weight;
     }
}
