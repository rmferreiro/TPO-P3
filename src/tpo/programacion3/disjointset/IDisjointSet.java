package tpo.programacion3.disjointset;

public interface IDisjointSet {
    //void find(int x);
    int find(int x);
    void union(int x, int y);
    int count();
}
