// compare mid with right side!
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else // nums[mid] < nums[r] mid will never == r, since mid == r then l == r
                r = mid;
        }
        return nums[l]; // or return nums[r];
    }
}
