// https://discuss.leetcode.com/topic/71438/c-dp-solution-with-comments
// https://discuss.leetcode.com/topic/76103/0-1-knapsack-detailed-explanation
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String s : strs) {
            int zeros = 0, ones = 0;
            for(char c : s.toCharArray()) {
                if(c - '0' == 0) zeros++;
                else ones++;
            }

            // has to go from bigger to lower to avoid count the current string multiple times.
            for(int i=m; i>=zeros; i--) {
                for(int j=n; j>=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zeros][j-ones]);
                }
            } // else not able to select the current string, no change to dp[i][j].
        }

        return dp[m][n];
    }
}
