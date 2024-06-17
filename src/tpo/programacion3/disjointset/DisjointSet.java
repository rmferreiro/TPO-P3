package tpo.programacion3.disjointset;

public class DisjointSet implements IDisjointSet {
    private final int[] parent, size;
    private int count;

    public DisjointSet(int initialSize) {
        parent = new int[initialSize];
        size = new int[initialSize];
        count = initialSize;
        for (int i = 0; i < initialSize; i++) {
            parent[i] = i;
            this.size[i] = 1;
        }
    }

    @Override
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    @Override
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
            count--;
        }
    }

    @Override
    public int count() {
        return count;
    }
}
