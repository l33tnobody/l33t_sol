class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, m, n); // or pass in a integer reference for sum
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        grid[i][j] = 0; // or can use a boolean visited[][] array to record visiting
        return 1 + dfs(grid, i-1, j, m, n) + dfs(grid, i+1, j, m, n) + dfs(grid, i, j-1, m, n) + dfs(grid, i, j+1, m, n);
    }
}