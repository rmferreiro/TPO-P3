package tpo.programacion3.heap;

import tpo.programacion3.graph.Edge;

import java.util.PriorityQueue;

public class MinHeap implements IHeap {
    private final PriorityQueue<Edge> heap;

    public MinHeap() {
        this.heap = new PriorityQueue<>();
    }

    @Override
    public void push(Edge a) {
        heap.add(a);
    }

    @Override
    public void pop() {
        heap.poll();
    }

    @Override
    public Edge first() {
        return heap.peek();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
