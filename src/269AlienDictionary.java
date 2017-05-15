public class Solution {
    private final int N = 26;

    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N]; // -1 did not appear yet, 0 not visited, 1 visiting, 2 visited.
        Arrays.fill(visited, -1);

        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder(); // using as a stack for topological sort
        for(int i=0; i<N; i++) {
            if(visited[i] == 0) {
                if (!dfs(visited, adj, i, sb)) return "";    // circle
            }
        }

        return sb.toString();
    }

    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        for(int i=0; i<words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0; // the char appeared

            if(i == 0) continue;

            String w0 = words[i-1];
            String w1 = words[i];
            for(int j=0; j<Math.min(w0.length(), w1.length()); j++) {
                if(w0.charAt(j) != w1.charAt(j)) {
                    adj[w0.charAt(j) - 'a'][w1.charAt(j) - 'a'] = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int[] visited, boolean[][] adj, int u, StringBuilder sb) {
        visited[u] = 1; //visiting
        for(int v=0; v<N; v++) {
            if(adj[u][v]){
                if(visited[v] == 1) return false;
                if(visited[v] == 0 && !dfs(visited, adj, v, sb)) return false;
            }
        }
        sb.insert(0, (char)('a' + u));
        visited[u] = 2;
        return true;
    }
}
