// use rowhit and colhit cache to minimize runtime to O(mn), each grid cell is counted once in cache
// brute force would be O(mn*(m+n))
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        int max = 0;
        int rowhits = 0;
        int[] colhits = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0 || grid[i][j-1] == 'W') {
                    rowhits = 0;
                    for(int k=j; k<n && grid[i][k] != 'W'; k++) {
                        if(grid[i][k] == 'E') rowhits++;
                    }
                }

                if(i == 0 || grid[i-1][j] == 'W') {
                    colhits[j] = 0;
                    for(int k=i; k<m && grid[k][j] != 'W'; k++) {
                        if(grid[k][j] == 'E') colhits[j]++;
                    }
                }

                if(grid[i][j] == '0') {
                    int maxhere = rowhits + colhits[j];
                    max = Math.max(max, maxhere);
                }
            }
        }

        return max;
    }
}
