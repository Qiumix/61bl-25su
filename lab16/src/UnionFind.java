public class UnionFind {

    /* [x]: Add instance variables here. */
    private int[] items;

    /*
     * Creates a UnionFind data structure holding N items. Initially, all
     * items are in disjoint sets.
     */
    public UnionFind(int N) {
        items = new int[N];
        for (int i = 0; i < items.length; i++) {
            items[i] = -1;
        }
        // [x]: YOUR CODE HERE
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // [x]: YOUR CODE HERE
        return -items[find(v)];
    }

    /*
     * Returns the parent of V. If V is the root of a tree, returns the
     * negative size of the tree for which V is the root.
     */
    public int parent(int v) {
        // [x]: YOUR CODE HERE
        return items[v];
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // [x]: YOUR CODE HERE
        return find(v2) == find(v1);
    }

    /*
     * Returns the root of the set V belongs to. Path-compression is employed
     * allowing for fast search-time. If invalid items are passed into this
     * function, throw an IllegalArgumentException.
     */
    public int find(int v) {
        // [x]: YOUR CODE HERE
        if (v >= items.length || v < 0) {
            throw new IllegalArgumentException();
        }
        if (items[v] < 0) {
            return v;
        }
        items[v] = find(items[v]);
        return items[v];
    }

    /*
     * Connects two items V1 and V2 together by connecting their respective
     * sets. V1 and V2 can be any element, and a union-by-size heuristic is
     * used. If the sizes of the sets are equal, tie break by connecting V1's
     * root to V2's root.
     */
    public void union(int v1, int v2) {
        // [x]: YOUR CODE HERE
        if (connected(v1, v2)) {
            return;
        }
        if (sizeOf(v1) > sizeOf(v2)) {
            items[find(v1)] += items[find(v2)];
            items[find(v2)] = v1;
        } else {
            items[find(v2)] += items[find(v1)];
            items[find(v1)] = v2;
        }
    }
}
