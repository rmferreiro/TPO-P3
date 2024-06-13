package tpo.programacion3.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph implements IGraph {
    private final List<Edge> edges;
    private final int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.edges = new ArrayList<>();
    }

    @Override
    public void addEdge(int o, int d, int w) {
        edges.add(new Edge(o, d, w));
    }

    @Override
    public List<Edge> edges() {
        return edges;
    }

    public int getNumVertices() {
        return numVertices;
    }
}
