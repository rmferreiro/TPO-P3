package tpo.programacion3.heap;

import tpo.programacion3.graph.Edge;

import java.util.ArrayList;
import java.util.List;

public class MinHeap implements IHeap {
    private final List<Edge> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    @Override
    public void push(Edge a) {
        heap.add(a);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public void pop() {
        if (heap.size() > 1) {
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            heapifyDown(0);
        } else if (heap.size() == 1) {
            heap.remove(0);
        }
    }

    @Override
    public Edge first() {
        return heap.isEmpty() ? null : heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        Edge temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
