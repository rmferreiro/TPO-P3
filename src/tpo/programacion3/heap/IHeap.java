package tpo.programacion3.heap;

import tpo.programacion3.graph.Edge;

public interface IHeap {
    void push(Edge a);
    void pop();
    Edge first();
    boolean isEmpty();
}
