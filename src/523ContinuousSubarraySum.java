// worst cast can do i start from 0 to n-2 and j start from i+1 to n-1 and %: O(n)

// An O(n) solution: using the fact that sum added with a multiple, the remainder does not change
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // remainder to index
        map.put(0, -1);

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(k != 0) sum %= k; // also works when k is 0
            Integer prev = map.get(sum);
            if(prev != null ) {
                if (i - prev >= 2) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
