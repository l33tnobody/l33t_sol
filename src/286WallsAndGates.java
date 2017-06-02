public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0) return;
        int n = rooms[0].length;
        if(n == 0) return;

        List<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        }

        while(q.size() != 0) {
            int[] cell = q.remove(0);
            int r = cell[0];
            int c = cell[1];

            int v = rooms[r][c];
            if(r>0 && rooms[r-1][c] == Integer.MAX_VALUE) {
                rooms[r-1][c] = v + 1;
                q.add(new int[]{r-1, c});
            }
            if(r<m-1 && rooms[r+1][c] == Integer.MAX_VALUE) {
                rooms[r+1][c] = v + 1;
                q.add(new int[]{r+1, c});
            }
            if(c>0 && rooms[r][c-1] == Integer.MAX_VALUE) {
                rooms[r][c-1] = v + 1;
                q.add(new int[]{r, c-1});
            }
            if(c<n-1 && rooms[r][c+1] == Integer.MAX_VALUE) {
                rooms[r][c+1] = v + 1;
                q.add(new int[]{r, c+1});
            }
        }
    }
}

// also https://discuss.leetcode.com/topic/35242/benchmarks-of-dfs-and-bfs
// and https://discuss.leetcode.com/topic/33459/my-short-java-solution-very-easy-to-understand
