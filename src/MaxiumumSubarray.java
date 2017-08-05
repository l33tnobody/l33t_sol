// both array and subarray non-empty
public class Solution {
    public int maxSubArray(int[] A) {
        int maxsum=A[0];
        int sum=A[0];

        for(int i=1;i<A.length;i++){
            if(sum<0)   sum=0;
            sum+=A[i];
            if(maxsum<sum)  maxsum=sum;
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
