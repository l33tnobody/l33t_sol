// better:
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] res = new int[m+1][n+1]; //default to 0
        res[0][1] = 1;

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if (obstacleGrid[i-1][j-1] == 0) {
                    res[i][j] = res[i-1][j] + res[i][j-1];
                }
            }
        }

        return res[m][n];
    }
}

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][] res=new int[m][n];
        res[0][0]= obstacleGrid[0][0]==1?0:1;

        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                if (obstacleGrid[i][j]==0){
                    res[i][j] += (i-1 < 0 ? 0 : res[i-1][j]) + (j-1 < 0 ? 0 : res[i][j-1]);
                }
            }

        return res[m-1][n-1];
    }
}
