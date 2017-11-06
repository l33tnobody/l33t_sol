class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<m+1; i++) { dp[i][0] = dp[i-1][0] + s1.charAt(i-1); }
        for(int j=1; j<n+1; j++) { dp[0][j] = dp[0][j-1] + s2.charAt(j-1); }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                char c1 = s1.charAt(i-1), c2 = s2.charAt(j-1);
                if(c1 == c2) { dp[i][j] = dp[i-1][j-1]; continue; }

                dp[i][j] = Math.min(Math.min(dp[i-1][j] + c1, dp[i][j-1] + c2), dp[i-1][j-1] + c1 + c2);
            }
        }

        return dp[m][n];
    }
}
