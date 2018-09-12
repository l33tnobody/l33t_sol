class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0, presum = 0;
        for(int n : nums) total += n;
        
        for(int i=0; i<nums.length; i++) {
            if(presum == total - nums[i] - presum) return i;
            presum += nums[i];
        }
        
        return -1;
    }
}