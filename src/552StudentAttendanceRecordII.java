class Solution {
    public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3]; // f[i][j][k] meaning at ith attendance, at most j As and at most k trailing Ls

        f[1] = new int[][]{{1, 2, 2}, {2, 3, 3}}; // base case for 1 attendance record
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P: append P and making k to at most 0 trailing L, so works for any k
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A: append A only for previous 0 As (to get at most 1A) and making this no trailing Ls works for any k; and if j==0 cannot append A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L: append L to previous at most k-1 Ls to get at most k Ls; if k==0 cannot append L
                    f[i][j][k] = val;
                }
            }
        }
        return f[n][1][2];
    }
}
