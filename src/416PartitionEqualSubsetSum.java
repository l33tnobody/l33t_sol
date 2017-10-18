// 0/1 knapsack problem! pick the current element or not
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;

        if((sum & 1) == 1) return false;

        sum /= 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++) dp[i][0] = true;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                dp[i][j] = dp[i-1][j]; // not picking i th number
                if(j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}

// can reduce space complexity by using only sum array
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;

        if((sum & 1) == 1) return false;

        sum /= 2;
        int n = nums.length;

        boolean[] dp = new boolean[sum+1];
        dp[0] = true; // for 0 numbers, all rest of sum numbers are false

        for(int i=1; i<=n; i++) {
            for(int j=sum; j >= nums[i-1]; j--) { // dp[0] is always true, has to go from higher to lower due to preserving previous lower dp index to refer to
                    dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }

        return dp[sum];
    }
}
