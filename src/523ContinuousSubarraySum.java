// brute force: O(n^2) try every subarray
// An O(n) solution: using the fact that when sum added with a multiple, the remainder does not change
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // remainder to index
        map.put(0, -1); // sum 0, mod 0 to begin with at index -1

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum %= k; // also works when k is 0
            Integer prev = map.get(sum);
            if(prev != null ) {
                if (i - prev >= 2) return true;
                // otherwise no set again for this remainder to get longest possible subarray
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
