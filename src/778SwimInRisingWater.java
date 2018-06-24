// the problem should be phrased as: when both adjacent squares level, one can swim over.
// heap: n*n*logn: greedily find the next smallest square to jump to
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (grid[a/n][a%n] - grid[b/n][b%n])); // min heap to find smallest next cube to go to
        Set<Integer> added = new HashSet<>(); // prevent from revisit the same cube again i.e. loop
        pq.offer(0);
        added.add(0);
        int res = 0;
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!pq.isEmpty()) {
            int next = pq.poll();
            int r = next/n, c = next%n;
            res = Math.max(res, grid[r][c]);
            if(r == n-1 && c == n-1) return res;
            
            for(int d[] : neighbors) {
                int rr = r + d[0], cc = c + d[1];
                int ni = rr * n + cc;
                if(rr >= 0 && rr < n && cc >= 0 && cc < n && !added.contains(ni)) {
                    pq.offer(ni);
                    added.add(ni);
                }
            }
        }
        
        return Integer.MIN_VALUE;
    }
}

// binary search: n*n*logn
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int lo = grid[0][0], hi = n*n-1; // at least grid[0][0] to be able to move to other squares
        
        while(lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if(!possible(mi, grid)) lo = mi + 1;
            else hi = mi;
        }
        
        return hi;
    }
    
    private boolean possible(int T, int[][] grid) { // DFS from start to end at maximum T time/water level
        int n = grid.length;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(0);
        seen.add(0);
        int[][] neighbors = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(!stack.isEmpty()) {
            int next = stack.pop();
            int r = next / n, c = next % n;
            if(r == n-1 && c == n-1) return true;
            
            for(int d[] : neighbors) {
                int rr = r + d[0], cc = c + d[1];
                int ni = rr * n + cc;
                if(rr >= 0 && rr < n && cc >= 0 && cc < n && !seen.contains(ni) && grid[rr][cc] <= T) {
                    stack.push(ni);
                    seen.add(ni);
                }
            }
        }
        
        return false;
    }
}



// just for fun: or use union-find: same runtime
class solution {
    private int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int swimInWater(int[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int N = grid.length;
        int[][] indexes = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                indexes[grid[i][j]][0] = i;
                indexes[grid[i][j]][1] = j;
            }
        }
        for (int i = 0; i < N * N; i++) {
            int[] p = indexes[i];
            for (int[] d : dirs) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x < 0 || x >= N || y < 0 || y >=N || grid[x][y] > i) continue;
                // union with smaller neighbors
                uf.union(p[0] * N + p[1], x * N + y);
            }
            if (uf.isConnected()) return i;
        }

        return N * N; // dummy. will not be executed
    }

    class UnionFind {
        int[] parent;

        UnionFind(int[][] grid) {
            int N = grid.length;
            parent = new int[N * N];

            for (int i = 0; i < N * N; i++) {
                parent[i] = i;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                // path compression
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            // ...
        }

        public boolean isConnected() {
            return find(0) == find(parent.length - 1);
        }
    }
}