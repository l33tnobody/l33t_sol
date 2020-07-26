class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int n = A.length;
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=0; i<n; i++) {
            int max = 0; // A[i] >= 0
            for(int k=0; k<K && i-k >=0 ; k++) {
                max = Math.max(max, A[i-k]);
                dp[i+1] = Math.max(dp[i+1], dp[i-k] + max*(k+1));
            }
        }

        return dp[n];
    }
}