public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] lastrowres=new int[n];
        for(int i=1; i<n; i++)   lastrowres[i]=Integer.MAX_VALUE;
        lastrowres[0]=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                lastrowres[j]= Math.min(lastrowres[j], ((j-1<0)?Integer.MAX_VALUE:lastrowres[j-1])) + grid[i][j];
            }
        }

        return lastrowres[n-1];
    }
}

// or: use more mem dp matrix
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=2; i<n+1; i++) {
            dp[0][i]=Integer.MAX_VALUE;
        }
        dp[0][0] = dp[0][1] = 0;
        for(int j=1; j<m+1; j++) {
            dp[j][0]=Integer.MAX_VALUE;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[m][n];
    }
}
