class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for(int step=1; step <= n-1; step++) {
            for(int i=0; i+step<n; i++) {
                int j = i + step;
                dp[i][j] = step + 1; // max times needed
                for(int k = i+1; k <=j; k++) {
                    int res = dp[i][k-1] + dp[k][j];
                    if(s.charAt(i) == s.charAt(k)) res--; // e.g. "aab"
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }

        return dp[0][n-1];
    }
}
