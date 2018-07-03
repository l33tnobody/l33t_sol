class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int i=0; i<n; i++) {
            if(colors[i] == -1) {
                if(!validColor(graph, colors, 0, i)) return false;
            }
        }
        
        return true;
    }
    
    private boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if(colors[node] != -1) return color == colors[node];
        
        colors[node] = color;
        for(int n : graph[node]) {
            if(!validColor(graph, colors, color^1, n)) return false;
        }
        return true;
    }
}

// dfs with stack:
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Stack<Integer> stack = new Stack();
                color[start] = 0;
                stack.push(start);

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            color[nei] = color[node] ^ 1;
                            stack.push(nei);
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}