// DFS with Cache
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, 0, S, new HashMap<>());
    }

    private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map) {
        if (index == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        }

        String encodedString = index + ":" + sum;
        if (map.containsKey(encodedString)) return map.get(encodedString);

        int curNum = nums[index];
        int add = helper(nums, index + 1, sum + curNum, S, map);
        int minus = helper(nums, index + 1, sum - curNum, S, map);
        int res = add + minus;
        map.put(encodedString, res);

        return res;
    }
}

// using SubsetSum similar to 416PartitionEqualSubsetSum: 0/1 knapsack problem
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
       // https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
//                   sum(P) - sum(N) = target   where P for positive and N for negative
// sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
//                        2 * sum(P) = target + sum(nums)
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum < S || -sum > S || ((S + sum) & 1) == 1) return 0;

        return subsetSum(nums, (S + sum) >> 1); //convert the original problem to how many ways to get sum(P) (positive) from the array.
    }

    public int subsetSum(int[] nums, int s) {

        int n = nums.length;
        int[][] dp = new int[n + 1][s + 1];
        dp[0][0] = 1;

        // dp[0][a positive number] is by default 0
        for (int i=1; i<=n; i++) {
            for (int j = 0; j <= s; j++) {
                dp[i][j] += dp[i-1][j];
                if(nums[i-1] <= j) {
                    dp[i][j] += dp[i-1][j - nums[i-1]];
                }
            }
        }

        return dp[n][s];

        // reduced space edition:
        // int[] dp = new int[s + 1];
        // dp[0] = 1; // starting with no nums, 0 has one way to get, else positive numbers got 0 way

        // for (int n : nums)
        //      for (int i = s; i >= n; i--)
        //         dp[i] += dp[i - n];

        // return dp[s];
    }
}
