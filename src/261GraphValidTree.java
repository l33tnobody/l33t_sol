public class Solution {
    // connected but no circle, edges = n - 1 necessary, but n - 1 edges might have circle
    // so next is to detect circle with UF
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // make sure there is no global cycle
        for (int[] e : edges) {
            int x = find(parent, e[0]);
            int y = find(parent, e[1]);

            if (x == y)
                return false; // there is a loop, the two nodes connected by the edge are already connected.

            // union
            parent[x] = y;
        }

        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;

        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}


// DFS, check no of edges and no cycle for each node
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        // and then check no cycle for each node
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        // convert edge list to adjacency list
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        // detect circles
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycle(adjList, visited, i, -1))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, boolean[] visited, int u, int parent) {
        visited[u] = true;

        for (int v : adjList.get(u)) {
            if (v == parent)
                continue;
            if (visited[v])
                return true;
            if (hasCycle(adjList, visited, v, u))
                return true;
        }

        return false;
    }
}

// similar to above but use int[] visited array: 0 unvisted, 1 visiting, 2 visited.
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        // and then check no cycle for each node
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        // convert edge list to adjacency list
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        int[] visited = new int[n];

        // detect circles
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (hasCycle(adjList, visited, i, -1))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adjList, int[] visited, int u, int parent) {
        visited[u] = 1;

        for (int v : adjList.get(u)) {
            if (v == parent)
                continue;
            if (visited[v] == 1)
                return true;
            if (visited[v] == 0 && hasCycle(adjList, visited, v, u))
                return true;
        }

        visited[u] = 2;
        return false;
    }
}
