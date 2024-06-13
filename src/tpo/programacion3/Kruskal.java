package tpo.programacion3;

import tpo.programacion3.disjointset.DisjointSet;
import tpo.programacion3.graph.Edge;
import tpo.programacion3.graph.Graph;
import tpo.programacion3.heap.MinHeap;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    // Kruskal minimum spanning tree
    public static List<Edge> kruskalMST(Graph graph) {
        List<Edge> result = new ArrayList<>();
        MinHeap minHeap = new MinHeap();
        for (Edge edge : graph.edges()) {
            minHeap.push(edge);
        }

        DisjointSet disjointSet = new DisjointSet(graph.getNumVertices());

        while (!minHeap.isEmpty() && result.size() < graph.getNumVertices() - 1) {
            Edge edge = minHeap.first();
            minHeap.pop();

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
