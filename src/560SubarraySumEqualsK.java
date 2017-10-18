// Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k.
// Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.

// Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
// So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
// To achieve this, we just need to go through the array,
// calculate the current sum and save number of all seen PreSum to a HashMap.
// Time complexity O(n), Space complexity O(n).

class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> presum = new HashMap<>(); // map from a presum value to how many of such presum

        presum.put(0, 1); // start with 0 as sum, count 1
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(presum.containsKey(sum-k)) { res += presum.get(sum-k); }
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}