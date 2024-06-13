package tpo.programacion3.graph;

import java.util.List;

public interface IGraph {
    void addEdge(int o, int d, int w);
    List<Edge> edges();
}
