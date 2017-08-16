public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }

        int m=matrix.length, n=matrix[0].length, max=0;

        // dp(i, j) represents the max length of the square
        // whose lower-right corner is located at (i, j)
        // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) } + 1 if it is '1'
        int[][] dp = new int[m+1][n+1]; // default to 0

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
