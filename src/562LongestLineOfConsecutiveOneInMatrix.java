class Solution {
    public int longestLine(int[][] M) {
        int m = M.length;
        if(m == 0) return 0;
        int n = M[0].length;
        if(n == 0) return 0;
        int[][][] dp = new int[m][n][4];
        int max = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(M[i][j] == 1) {
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = dp[i][j][3] = 1; // at least 1, to add more if possible
                    if(i > 0) dp[i][j][0] += dp[i-1][j][0]; // vertical
                    if(j > 0) dp[i][j][1] += dp[i][j-1][1]; // horizontal
                    if(i > 0 && j > 0) dp[i][j][2] += dp[i-1][j-1][2];
                    if(i > 0 && j < n-1) dp[i][j][3] += dp[i-1][j+1][3];
                    
                    max = Math.max(max, dp[i][j][0]);
                    max = Math.max(max, dp[i][j][1]);
                    max = Math.max(max, dp[i][j][2]);
                    max = Math.max(max, dp[i][j][3]);
                } // 0 means all 0 for dp table which is the default
            }
        }
        
        return max;
    }
}

// can optimize the space usage by using only one row of dp[]: need to keep a copy of \ diagonal prev value since it might be updated in the dp[] row
for (int i = 0; i < M.length; i++) {
    int old = 0;
    for (int j = 0; j < M[0].length; j++) {
        if (M[i][j] == 1) {
            dp[j][0] = j > 0 ? dp[j - 1][0] + 1 : 1;
            dp[j][1] = i > 0 ? dp[j][1] + 1 : 1;
            int prev = dp[j][2];
            dp[j][2] = (i > 0 && j > 0) ? old + 1 : 1;
            old = prev;
            dp[j][3] = (i > 0 && j < M[0].length - 1) ? dp[j + 1][3] + 1 : 1;
            ones = Math.max(ones, Math.max(Math.max(dp[j][0], dp[j][1]), Math.max(dp[j][2], dp[j][3])));
        } else {
            old = dp[j][2];
            dp[j][0] = dp[j][1] = dp[j][2] = dp[j][3] = 0;
        }
    }
}