public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]<nums[r])
                r = mid;
            else if (nums[mid]>nums[r])
                l = mid+1;
            else // nums[mid] == nums[r] not sure right side is sorted or not, but safe to move the r to left by one
                r--;    // r will not be the only min one so disgard r move to the left
        }
        return nums[l];
    }
}
