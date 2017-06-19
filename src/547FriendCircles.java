// dfs
public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++) {
            for(int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                dfs(adj, visited, i);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int i) {
        visited[i] = true;
        for(int j : adj.get(i)) {
            if (!visited[j]) {
                dfs(adj, visited, j);
            }
        }
    }
}

// union-find
public class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int count = n;
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if (M[i][j] == 1) {
                    int pi = find(parent, i);
                    int pj = find(parent, j);
                    if (pi != pj) {
                        parent[pi] = pj;
                        count--;
                    }
                }
            }
        }

        return count;
    }

    private int find(int [] parent, int i) {
        if(parent[i] == i) return i;

        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
