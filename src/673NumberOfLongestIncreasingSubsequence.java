class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // longest ending in i
        int[] count = new int[n]; // how many longest ending in i
        int maxlen = 0, res = 0;

        for(int i=0; i<n; i++) {
            dp[i] = count[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }

            if(maxlen < dp[i]) {
                maxlen = dp[i];
                res = count[i];
            } else if(maxlen == dp[i]) {
                res += count[i];
            }
        }

        return res;
    }
}
