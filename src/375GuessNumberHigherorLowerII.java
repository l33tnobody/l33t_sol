// dp with steps
public class Solution {
    // strategy: https://discuss.leetcode.com/topic/68252/clarification-on-the-problem-description-problem-description-need-to-be-updated
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1]; // by default 0, table[i][i] == 0;
        for(int step = 1; step < n; step++) { // step from 1 to n-1
            for(int i = 1; i + step <= n; i++) {
                int j = i + step;
                int res = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    int costk = k + Math.max( k == i ? 0 : table[i][k-1], k == j ? 0 : table[k+1][j]);
                    res = Math.min(res, costk);
                }
                table[i][j] = res;
            }
        }
        return table[1][n];
    }
}

// another way to do dp, steps from small to big
public class Solution {
    // strategy: https://discuss.leetcode.com/topic/68252/clarification-on-the-problem-description-problem-description-need-to-be-updated
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1]; // by default 0, table[i][i] == 0;
        for(int j=2; j<=n; j++) {
            for(int i=j-1; i>0; i--) {
                int res = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    int costk = k + Math.max( k == i ? 0 : table[i][k-1], k == j ? 0 : table[k+1][j]);
                    res = Math.min(res, costk);
                }
                table[i][j] = res;
            }
        }
        return table[1][n];
    }
}


// in case of expected loss: https://discuss.leetcode.com/topic/51375/minimizing-the-expected-loss-instead-of-worst-case-loss/5
