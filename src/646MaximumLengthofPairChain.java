class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int len = pairs.length;
        int[] dp = new int[len];
        int res = 0;

        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]){
                    dp[i]  = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
