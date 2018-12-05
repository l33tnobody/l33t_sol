// if subarray and array cannot be empty:
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxsum = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(sum < 0) sum = 0;
            sum += nums[i];
            if(sum > maxsum) maxsum = sum;
        }

        return maxsum;
    }
}

// if subarray can be empty:
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxsum = 0;

        for(int i=0; i<nums.length; i++) {
            if(sum < 0)   sum=0;
            sum += nums[i];
            if(maxsum < sum)  maxsum = sum;
        }

        return maxsum;
    }
}
