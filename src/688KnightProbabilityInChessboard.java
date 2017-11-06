class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        double[][] dp = new double[N][N];
        for(double[] row : dp) { Arrays.fill(row, 1); } // for step 0

        for(int step=1; step<=K; step++) {
            double[][] dpnew = new double[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    for (int[] m : moves) {
                        int rr = i + m[0];
                        int cc = j + m[1];
                        if (rr>=0 && rr<N && cc>=0 && cc<N) dpnew[i][j] += 0.125 * dp[rr][cc];
                    }
                    // or little optimize here 0.125* or /8 here on dpnew[i][j]
                }
            }
            dp = dpnew;
        }
        return dp[r][c]; // can be optimized to (dp[r][c] / Math.pow(8, K)) and remove the 0.125* in line 14: divide(multiply) only once
    }
}
