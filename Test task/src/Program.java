public class Program {
    public static void main(String[] args) {
        DisjointedSetUnion dsu = new DisjointedSetUnion(8);

        dsu.union(1, 4);
        dsu.union(4, 5);

        dsu.union(2, 3);
        dsu.union(2, 6);
        dsu.union(3, 6);
        dsu.union(3, 7);

        dsu.union(2, 5);

        boolean resultOfSearch = dsu.find(0, 1);
    }
}
