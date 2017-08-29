class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] pre = new int[n];

        int max = 0; int maxidx = -1;
        Arrays.sort(nums); // only needs to be divisible by the biggest number after sorting
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for(int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxidx = i;
            }
        }

        List<Integer> res = new LinkedList<>();
        while(maxidx != -1) { // or while(max-- > 0) { // no need to set pre[i] = -1 on line 11 in this case
            res.add(0, nums[maxidx]);
            maxidx = pre[maxidx];
        }

        return res;
    }
}
