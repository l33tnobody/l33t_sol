// Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k.
// Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.

// Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j].
// So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j].
// To achieve this, we just need to go through the array,
// calculate the current sum and save number of all seen PreSum to a HashMap.
// Time complexity O(n), Space complexity O(n).

class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> m = new HashMap<>(); // map from a cumulative sum (or presum) value to how many of such sum
        
        m.put(0, 1); // start with 0 as sum, count 1
        for(int n : nums) {
            sum += n;
            if(m.containsKey(sum - k)) res += m.get(sum-k);
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}

// time n*n space n solution:
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        for(int s=0; s<n; s++) {
            int sum = 0;
            for(int e=s; e<n; e++) {
                sum += nums[e];
                if(sum == k) count++;
            }
        }
        
        return count;
    }
}
