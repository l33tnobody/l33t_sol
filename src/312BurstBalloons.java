// https://discuss.leetcode.com/topic/30746/share-some-analysis-and-explanations

public class Solution {
    public int maxCoins(int[] nums) {
        int[] mynums = new int[nums.length + 2];
        int n = mynums.length;
        mynums[0] = mynums[n - 1] = 1;

        for(int i=0; i<nums.length; i++) {
            mynums[i+1] = nums[i]; // can remove the 0 balloons, as they do not matter to final result
        }

        int[][] dp = new int[n][n];
        for(int step=2; step<=n-1; step++) { // step is distance of end - start
            for(int l=0; l+step<n; l++) {
                int r = l + step;
                // dp[l][r] is 0 in the beginning
                for(int i=l+1; i<r; i++) {
                    dp[l][r] = Math.max(dp[l][r], mynums[l]*mynums[i]*mynums[r] + dp[l][i] + dp[i][r]); // by default step 1 val is 0
                }
            }
        }

        return dp[0][n-1];
    }
}


// with memorization, top-down recursive
public class Solution {
    public int maxCoins(int[] nums) {
        int[] mynums = new int[nums.length + 2];
        int n = mynums.length;
        mynums[0] = mynums[n - 1] = 1;

        for(int i=0; i<nums.length; i++) {
            mynums[i+1] = nums[i]; // can remove the 0 balloons, as they do not matter to final result
        }

        int[][] memo = new int[n][n];
        return burst(memo, mynums, 0, n-1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 >= right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
            + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }
}
