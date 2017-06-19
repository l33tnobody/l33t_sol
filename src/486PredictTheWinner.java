public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        // if (n % 2 == 0) { // an optimization
        //     return true; // can always pick the greater or equal solution
        // }

        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) dp[i][i] = nums[i]; // the score win over the opponent

        for(int step=1; step<n; step++) {
            for(int i=0; i+step<n; i++) {
                int j = i + step;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }

        return dp[0][n-1] >= 0;
    }
}

// recursion with memorization
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length]) >= 0;
    }

    private int helper(int[] nums, int s, int e, Integer[][] mem){
        if(mem[s][e] != null) return mem[s][e];

        int res = s==e ? nums[e] : Math.max(nums[e] - helper(nums, s, e-1, mem), nums[s] - helper(nums, s+1, e, mem));

        mem[s][e] = res;
        return res;
    }
}
