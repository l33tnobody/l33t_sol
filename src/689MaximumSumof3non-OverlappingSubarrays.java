// time O(n), space O(n), instead of brute force O(n^3) time to loop 3 windows
// lexicographically smallest indexes means the first index that has the max sum value
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[4][n]; // dp[i][j] means for i windows, the max non-overlap sum ending up to j of the last window
        int[] accu = new int[n+1];
        for(int i=1; i<=n; i++) { // shift to right by one, or call it presum
            accu[i] = accu[i-1] + nums[i-1];
        }
        int[][] id = new int[4][n]; // the start index of the ith window for the sum that has the max total

        for(int i=1; i<=3; i++) {
            int j = k - 1 + (i-1)*k;
            dp[i][j] = accu[j+1] - accu[j+1-k];
            if(j - k >= 0) dp[i][j] += dp[i-1][j-k]; // equivalent to i > 1
            id[i][j] = j - k + 1;
            j++;

            for(; j<n; j++) {
                dp[i][j] = dp[i][j-1];
                id[i][j] = id[i][j-1];

                int cursum = accu[j+1] - accu[j+1-k] + dp[i-1][j-k];
                if(cursum > dp[i][j-1]) { // the first max: lexicographically smallest
                    dp[i][j] = cursum;
                    id[i][j] = j - k + 1;
                }
            }
        }

        int[] res = new int[3];
        res[2] = id[3][n-1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];

        return res;
    }
}
