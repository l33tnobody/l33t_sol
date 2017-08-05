public class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int j=1;
            while(i-j*j>=0) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j++;
            }
        }

        return dp[n];
    }
}
