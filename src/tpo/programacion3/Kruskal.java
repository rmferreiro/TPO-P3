package tpo.programacion3;

import tpo.programacion3.disjointset.DisjointSet;
import tpo.programacion3.graph.Edge;
import tpo.programacion3.graph.Graph;
import tpo.programacion3.heap.Heap;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    // Kruskal minimum spanning tree
    public static List<Edge> kruskalMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        Heap heap = new Heap();
        for (Edge edge : graph.edges()) {
            heap.push(edge);
        }

        DisjointSet disjointSet = new DisjointSet(graph.getNumVertices());

        while (!heap.isEmpty() && result.size() < graph.getNumVertices() - 1) {
            Edge edge = heap.first();
            heap.pop();

            int rootSource = disjointSet.find(edge.getSource());
            int rootDest = disjointSet.find(edge.getDestination());

            if (rootSource != rootDest) {
                result.add(edge);
                disjointSet.union(rootSource, rootDest);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 9);
        graph.addEdge(0, 4, 14);
        graph.addEdge(1, 2, 10);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 11);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(5, 4, 9);
        List<Edge> mst = kruskalMST(graph);
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.getSource() + " - " + edge.getDestination() + " with weight " + edge.getWeight());
        }
    }
}
