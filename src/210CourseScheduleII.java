public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++) { adj.add(new ArrayList<>()); }

        for(int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[numCourses]; // init to all 0 unvisited, 1 visiting, 2 visited
        Stack<Integer> st = new Stack<>(); // for topological sort, or just use list queue w/o flipping afterwards

        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, adj, i, st)) return new int[0];
        }

        int[] res = new int[numCourses];
        int i = numCourses - 1;
        while(!st.isEmpty()) {
            res[i] = st.pop();
            i--;
        }
        return res;
    }

    private boolean dfs(int[] visited, List<List<Integer>> adj, int u, Stack<Integer> st) {
        visited[u] = 1; // visiting
        for(int v : adj.get(u)) {
            if (visited[v] == 1) return false;
            if (visited[v] == 0 && !dfs(visited, adj, v, st)) return false;
        }
        st.push(u); // after all requisites.
        visited[u] = 2;
        return true;
    }
}

// nothing fancy but just use a list/queue w/o flipping at the end
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++) { adj.add(new ArrayList<>()); }

        for(int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[numCourses]; // init to all 0, 1 visiting, 2 visited
        List<Integer> list = new ArrayList<>(); // for topological sort

        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 0 && !dfs(visited, adj, i, list)) return new int[0];
        }

        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private boolean dfs(int[] visited, List<List<Integer>> adj, int u, List<Integer> list) {
        visited[u] = 1; // visiting
        for(int v : adj.get(u)) {
            if (visited[v] == 1) return false;
            if (visited[v] == 0 && !dfs(visited, adj, v, list)) return false;
        }
        list.add(u); // after all requisites.
        visited[u] = 2;
        return true;
    }
}
