// https://discuss.leetcode.com/topic/97628/java-4-lines-recursion-with-step-by-step-explanation-to-derive-dp
class Solution {
    public int maxA(int N) {
        int[] dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            dp[i] = i;
            for(int j=1; j<=i-3; j++) { // dp[0] is 0, so the product is 0 too no need to consider
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 2 + 1));
            }
        }

        return dp[N];
    }
}

// recursion goes: // can add cache
// public int maxA(int n) {
//    int max = n;
//    for (int i = 1; i <= n - 3; i++)
//        max = Math.max(max, maxA(i) * (n - i - 1)); // n-i-2(control a and c)+1(original)
//    return max;
// }
