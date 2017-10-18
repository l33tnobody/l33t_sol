class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j); // with no knowledge of all equally small (least): dp[i] = Math.min(dp[i], dp[j] + (i/j));
                    break;                 // no break
                }
            }
        }

        return dp[n];
    }
}

// better:
class Solution {
    public int minSteps(int n) {
        int res = 0;

        for(int d=2; d<=n; d++) {
            while(n%d == 0){ // d copies
                res += d; // d-1 paste and one copy
                n /= d;
            }
        }

        return res;
    }
}
