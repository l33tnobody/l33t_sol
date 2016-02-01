public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[][] res=new int[m][n];
        res[0][0]= obstacleGrid[0][0]==1?0:1;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if (obstacleGrid[i][j]==0){
                    res[i][j] += (i-1<0?0:res[i-1][j])+(j-1<0?0:res[i][j-1]);
                }
            }
            
        return res[m-1][n-1];
    }
}
