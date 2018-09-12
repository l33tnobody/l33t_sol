class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for(int i=0; i <= grid.length-3; i++)
            for(int j=0; j <= grid[0].length-3; j++)
                if(helper(i, j, grid)) res++;
        return res;
    }  
    
    private boolean helper(int x, int y, int[][] grid) {
        if(grid[x+1][y+1] != 5) return false; // middle one has to be 5
        
        // check distinct element from 1-9
        int[] valid = new int[16]; // possible element 0 - 15
        for(int i=x; i<=x+2; i++)
            for(int j=y; j<=y+2; j++)
                valid[grid[i][j]]++;
        for (int v = 1; v <= 9; v++)
            if (valid[v] != 1) return false;
        
        // check two rows, the total is fixed due to 1-9, no need to check the third
        if(grid[x][y] + grid[x][y+1] + grid[x][y+2] != 15) return false;
        if(grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2] != 15) return false;
        // check two cols
        if(grid[x][y] + grid[x+1][y] + grid[x+2][y] != 15) return false;
        if(grid[x][y+1] + grid[x+1][y+1] + grid[x+2][y+1] != 15) return false;
        // check diagonal
        if(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != 15) return false;
        if(grid[x][y+2] + grid[x+1][y+1] + grid[x+2][y] != 15) return false;
        return true;
    }
}