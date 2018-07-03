// the question is essentially asking which nodes in the graph are not part of a circle
// so so dfs find all circle nodes and non circle nodes, and only add ones not in a circle

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
        if(c[i] != 0) return c[i] == 2; // visited without circle, otherwise 1 indicates circle
        
        // visiting unvisited i
        c[i] = 1;
        for(int nei : g[i]) {
            if(!dfs(nei, g, c)) return false; // leave status of c[i] to 1 indicating in a circle.
        }
        c[i] = 2; // visited without circle
        return true;
    }
}