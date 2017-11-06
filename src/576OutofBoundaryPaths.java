class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long limit = 1000000007;
        long[][][] dp = new long[N + 1][m][n]; // 0 step cannot move the ball out of bound, so all zero

        for (int k = 1; k <= N; k++) {
            for (int ii = 0; ii < m; ii++) {
                for (int jj = 0; jj < n; jj++) { // can make use of int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    dp[k][ii][jj] += ii == 0 ? 1 : dp[k - 1][ii - 1][jj];
                    dp[k][ii][jj] += ii == m - 1 ? 1 : dp[k - 1][ii + 1][jj];
                    dp[k][ii][jj] += jj == 0 ? 1 : dp[k - 1][ii][jj - 1];
                    dp[k][ii][jj] += jj == n - 1 ? 1 : dp[k - 1][ii][jj + 1];
                    dp[k][ii][jj] %= limit;
                }
            }
        }

        return (int)dp[N][i][j];
    }
}

// compact space: the current step only refers to the prev step: alternate dp tables

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        long limit = 1000000007;
        long[][][] dp = new long[2][m][n]; // 0 step cannot move the ball out of bound, so all zero

        for (int k = 1; k <= N; k++) {
            int kcur = k % 2; // Or create a new array everytime to switch
            int kprev = (k - 1) % 2;

            for (int ii = 0; ii < m; ii++) {
                for (int jj = 0; jj < n; jj++) { // can make use of int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                    dp[kcur][ii][jj] = 0; // clear result in this case
                    dp[kcur][ii][jj] += ii == 0 ? 1 : dp[kprev][ii - 1][jj];
                    dp[kcur][ii][jj] += ii == m - 1 ? 1 : dp[kprev][ii + 1][jj];
                    dp[kcur][ii][jj] += jj == 0 ? 1 : dp[kprev][ii][jj - 1];
                    dp[kcur][ii][jj] += jj == n - 1 ? 1 : dp[kprev][ii][jj + 1];
                    dp[kcur][ii][jj] %= limit;
                }
            }
        }

        return (int) dp[N % 2][i][j];
    }
}
