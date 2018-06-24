class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        long maxsum = Long.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(i>=k) sum-=nums[i-k];
            
            if(i>=k-1) {
                maxsum = Math.max(maxsum, sum);
            }
        }
        
        return maxsum * 1.0 / k;
    }
}