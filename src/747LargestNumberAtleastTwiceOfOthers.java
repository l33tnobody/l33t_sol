// one pass solution
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int mi1 = -1, mi2 = -1; // indexes
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max1) { // first largest
                max2 = max1;
                mi2 = mi1;
                max1 = nums[i];
                mi1 = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
                mi2 = i;
            }
        }
        
        if(max1 >= 2*max2) return mi1;
        else return -1;
    }
}