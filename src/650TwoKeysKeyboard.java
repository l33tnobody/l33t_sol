class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) { // larger the divider, less steps needed
                if (i % j == 0) { // must be largest divider, optimal result guaranteed
                    dp[i] = dp[j] + (i/j); // if with no knowledge of all equally small (least): dp[i] = Math.min(dp[i], dp[j] + (i/j));
                    break;                 // no break
                }
            }
        }

        return dp[n];
    }
}



// for fun: better, but probably cannot think of this
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
