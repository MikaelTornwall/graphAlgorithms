package algorithms.shortestpath.domain;

public class Vertice implements Comparable<Vertice> {
    
    public int node;
    public long weight;
    
    public Vertice(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Vertice control) {
        if (this.weight < control.weight) {
            return -1;
        } else if (this.weight > control.weight) {
            return 1;
        } else {
            return 1;
        }
    }
    
    @Override
    public String toString() {
        return this.node + ": " + this.weight;
    }
}
