class Solution {
    int[] p;
    int cnt = 0;
    int n = 0;

    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        cnt = n*n*4;
        p = new int[n*n*4];
        for(int i=0; i<n*n*4; i++) p[i] = i;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 1), g(i, j, 2));
                }
                if(grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 3), g(i, j, 2));
                }
                // up
                if(i>0) union(g(i-1, j, 2), g(i, j, 0));
                // left
                if(j>0) union(g(i, j-1, 1), g(i, j, 3));
            }
        }

        return cnt;
    }

    int g(int i, int j, int q) {
        return 4*(i*n + j) + q;
    }

    // int find(int x) {
    //     while(p[p[x]] != p[x]) {
    //         p[x] = p[p[x]];
    //     }
    //     return p[x];
    // }

    int find(int x) {
        if(p[x] == x) return x;

        p[x] = find(p[x]);

        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px != py) {
            p[px] = py;
            cnt--;
        }
    }
}