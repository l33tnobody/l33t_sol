public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n==1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        // return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        // using hashset for easier removal of elements
        for (int i=0; i<n; i++) adj.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }

        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int l : leaves) {
                int neighbor = adj.get(l).iterator().next();
                adj.get(neighbor).remove(l);
                if (adj.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}


// solution using longest path:
public class Solution {

    int n;
    List<Integer>[] e; //adjacency list

    private void bfs(int start, int[] dist, int[] pre) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>(); // or linkedlist
        queue.add(start);
        dist[start] = 0;
        visited[start] = true;
        pre[start] = -1; // to track the stop point of the longest path
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : e[u])
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                    pre[v] = u;
                }
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        e = new List[n];
        for (int i = 0; i < n; i++)
            e[i] = new ArrayList<>();
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];
            e[u].add(v);
            e[v].add(u);
        }

        int[] d1 = new int[n];
        int[] d2 = new int[n];
        int[] pre = new int[n];

        // find a leaf node, this can be done via adjacency list size() == 1 as well.
        bfs(0, d1, pre);
        int u = 0;
        for (int i = 0; i < n; i++)
            if (d1[i] > d1[u]) u = i;

        // find the longest path in the graph, it must be from one leaf node to another.
        bfs(u, d2, pre);
        int v = u;
        for (int i = 0; i < n; i++)
            if (d2[i] > d2[v]) v = i;

        List<Integer> list = new ArrayList<>();
        while (v != -1) {
            list.add(v);
            v = pre[v];
        }

        if (list.size() % 2 == 1)
            return Arrays.asList(list.get(list.size() / 2));
        else
            return Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));
    }
}
