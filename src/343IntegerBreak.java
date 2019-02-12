// preferred:
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            for(int j=1; j<i; j++) {
            // for(int j=1; 2*j<=i; j++) { // avoid half duplicate
                dp[i] = Math.max(dp[i], Math.max(j, dp[j])*Math.max(i-j, dp[i-j]));
                // or: dp[i] = Math.max(dp[i], (j < 4 ? j : dp[j])*(i-j < 4 ? i-j : dp[i-j]));
                // for 2 or 3 dp value is smaller than themselves, so dont devide. for 4 dp value equals 4. n>4,
                // dp for n is greater than n
            }
        }
        return dp[n];
    }
}



public class Solution {
    public int integerBreak(int n) {
        // https://discuss.leetcode.com/topic/43055/why-factor-2-or-3-the-math-behind-this-problem
        // try to get 3 the optimal factor (close to e)

        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4; // 2*2

        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;

        return product;

    }
}
