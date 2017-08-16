public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<len1+1; i++) dp[i][0] = i;

        for(int j=0; j<len2+1; j++) dp[0][j] = j;

        for(int i=1; i<len1+1; i++) {
            for(int j=1; j<len2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                // or optionally: dp[i][j] = Math.min(dp[i-1][j-1] + 2,  Math.min(dp[i-1][j], dp[i][j-1]) + 1);
                // dp[i-1][j-1] + 2 will never be the smallest. >= Math.max(dp[i-1][j], dp[i][j-1]) + 1
            }
        }

        return dp[len1][len2];
    }
}
