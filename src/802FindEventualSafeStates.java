// the question is essentially asking which nodes in the graph are not part of a cycle
// so use dfs find all cycle nodes and non cycle nodes, and only add ones not in a cycle

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                dfs(graph, visited, i);
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 2)
                res.add(i);
        }

        return res;
    }

    private boolean dfs(int[][] g, int[] visited, int i) {
        visited[i] = 1;
        for (int j : g[i]) {
            if (visited[j] == 1)
                return false;
            if (visited[j] == 0 && !dfs(g, visited, j))
                return false; // keep i state as 1
        }
        visited[i] = 2;
        return true;
    }
}

// a compact version with one pass.
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0 unvisited, 1 visiting, 2 visited

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(dfs(i, graph, colors)) res.add(i);
        }

        return res;
    }

    private boolean dfs(int i, int[][] g, int[] c) {
        if(c[i] != 0) return c[i] == 2; // visited without cycle, otherwise 1 indicates cycle

        // visiting unvisited i
        c[i] = 1;
        for(int nei : g[i]) {
            if(!dfs(nei, g, c)) return false; // leave status of c[i] to 1 indicating in a cycle.
        }
        c[i] = 2; // visited without cycle
        return true;
    }
}