public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++) { adj.add(new ArrayList<>()); }

        for(int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, adj, i)) return false;
        }

        return true;
    }

    private boolean dfs(int[] visited, List<List<Integer>> adj, int u) {
        visited[u] = 1;
        for(int v : adj.get(u)) {
            if (visited[v] == 1) return false;
            if (visited[v] == 0 && !dfs(visited, adj, v)) return false;
        }
        visited[u] = 2;
        return true;
    }
}
