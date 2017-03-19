public class Solution {
    // connected but no circle, edges = n - 1
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        // make sure there is no global cycle
        for(int[] e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);

            if (x == y) return false; // there is a loop

            // union
            parent[x] = y;
        }

        // test connected
        return edges.length == n - 1;
    }

    private int find(int[] parent, int v) {
        if (parent[v] == -1) return v;

        // optional path compression, flatten tall tree:
        // https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
        if (parent[parent[v]] != -1) parent[v] = parent[parent[v]];

        return find(parent, parent[v]);
    }
}

// DFS, adjacency list to test no loop and connected
public class Solution {
    // connected but no circle, edges = n - 1
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
            adjList.add(new ArrayList<>());

        // convert edge list to adjacency list
        for(int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // has no local cycle starting from 0
        if (hasCycle(adjList, visited, 0, -1))  return false;

        // make sure connected AND no global cycle
        for(boolean b : visited) {
            if (!b) return false;
        }

        return true;

        // return edges.length == n-1; // this won't work for local DFS
        /*
            Input:
                4
                [[2,3],[1,2],[1,3]]
                Output:
                true
                Expected:
                false
        */
    }

    private boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int u, int parent) {
        visited[u] = true;

        for (int v : adjList.get(u)) {
            if ((visited[v] && v != parent) ||
                (!visited[v] && hasCycle(adjList, visited, v, u)))
                return true;
        }

        return false;
    }
}
