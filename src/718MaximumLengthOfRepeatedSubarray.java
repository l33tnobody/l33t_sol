class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with A[i] and B[j]
        int[][] dp = new int[m + 1][n + 1]; // dp[0][x] and dp [x][0] is by default 0
        for(int i = 1;i <= m; i++) {
            for(int j = 1;j <= n; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }// otherwise keep dp[i][j] 0 not a common subarray ending in A[i-1] and B[j-1]
            }
        }
        return max;
    }
}
