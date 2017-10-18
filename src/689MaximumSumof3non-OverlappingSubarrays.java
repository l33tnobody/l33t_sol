class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[4][n]; // dp[i][j] means for i windows, the max non-overlap sum ending up to j of the last window
        int[] accu = new int[n+1];
        for(int i=1; i<=n; i++) { // shift to right by one, or call it presum
            accu[i] = accu[i-1] + nums[i-1];
        }
        int[][] id = new int[4][n]; // the start index of the ith window for the sum that has the max total

        for(int i=1; i<=3; i++) {
            int j = k - 1 + (i-1)*k;
            dp[i][j] = accu[j+1] - accu[j+1-k];
            if(j - k >= 0) dp[i][j] += dp[i-1][j-k];
            id[i][j] = j - k + 1;
            j++;

            for(; j<n; j++) {
                dp[i][j] = dp[i][j-1];
                id[i][j] = id[i][j-1];

                int cursum = accu[j+1] - accu[j+1-k] + dp[i-1][j-k];
                if(cursum > dp[i][j-1]) {
                    dp[i][j] = cursum;
                    id[i][j] = j - k + 1;
                }
            }
        }

        int[] res = new int[3];
        res[2] = id[3][n-1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];

        return res;
    }
}





// NOT recommened approach only applies for 3 windows and tricky in memorizing and calculation in dp array
// just for reference.
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxsum = Integer.MIN_VALUE;
        int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 1; i <= n; i++) sum[i] = sum[i-1] + nums[i-1];

        int total = sum[k]; // for k-1, and posLeft[k-1] = 0
        for(int i = k; i < n; i++) {
            int cursum = sum[i+1] - sum[i+1-k];
            if (cursum > total) {
                posLeft[i] = i-k+1;
                total = cursum;
            } else {
                posLeft[i] = posLeft[i-1];
            }
        }

        posRight[n-k] = n-k;
        total = sum[n] - sum[n-k];
        for (int i = n-1-k; i >= 0; i--) {
            int cursum = sum[i+k] - sum[i];
            if (cursum >= total) { // note >= here to get the smallest index
                posRight[i] = i;
                total = cursum;
            } else {
                posRight[i] = posRight[i+1];
            }
        }

        for (int i = k; i <= n-1-k-k+1; i++) {
            int l = posLeft[i-1], r = posRight[i+k]; // max indexes for left and right
            total = (sum[l+k-1+1] - sum[l-1+1]) + (sum[i+k-1+1] - sum[i]) + (sum[r+k-1+1] - sum[r-1+1]);
            if (total > maxsum) {
                maxsum = total;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }

        return ans;
    }
}
