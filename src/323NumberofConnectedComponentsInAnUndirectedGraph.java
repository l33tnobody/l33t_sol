// using union-find
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int count = n;

        for(int[] e : edges) {
            int p1 = find(parent, e[0]);
            int p2 = find(parent, e[1]);
            if (p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }
        return count;
    }

    private int find(int[] parent, int i) {
        if(parent[i] == i) return i;

        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}

// dfs
public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            count++;
            dfs(adj, visited, i);
        }

        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int i) {
        visited[i] = true;
        for(int j : adj.get(i)) {
            if(visited[j]) continue;
            dfs(adj, visited, j);
        }
    }
}

//bfs
public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            count++;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true; // in stack or already processed
            while (!q.isEmpty()) {
                int h = q.poll();
                for (int j : adj.get(h)) {
                    if (visited[j])
                        continue;
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }

        return count;
    }
}
