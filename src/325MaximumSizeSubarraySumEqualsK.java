// brute force O(n^2), this O(n) using cululative sum and a hashmap to record sum to its earliest index
// same but using a base case: map.put(0, -1);
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, maxlen=0;
        Map<Integer, Integer> map = new HashMap<>(); // from sum to its earliest index
        map.put(0, -1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                maxlen = Math.max(maxlen, i - map.get(sum-k)); 
            }

            if (!map.containsKey(sum)) map.put(sum, i);
        }

        return maxlen;
    }
}