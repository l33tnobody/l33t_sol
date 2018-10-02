class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                // time: 4*m*n
                if(i == 0 || grid[i-1][j] == 0) peri++; // up
                if(i == grid.length - 1 || grid[i+1][j] == 0) peri++; // down
                if(j == 0 || grid[i][j-1] == 0) peri++; // left
                if(j == grid[0].length - 1 || grid[i][j+1] == 0) peri++; // right
                // or only check down neighbors and right neighbors the perimeter is 4*1s - 2*neighbors: time 2*m*n
            }
        }
        return peri;
    }
}