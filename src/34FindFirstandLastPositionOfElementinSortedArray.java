public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = res[1] = -1;
        int n = nums.length;
        int l=0;
        int r=n-1;

        // get left side
        while(l<=r) {
            int m = l + (r - l)/2;
            if(nums[m] < target) l = m + 1;
            else r = m - 1; // nums[m] >= target
        }
        if (l>=n || nums[l] != target) return res;

        // otherwise the target exist in the nums
        res[0] = l;
        r = n - 1;
        while(l<=r) {
            int m = l + (r - l)/2;
            if(nums[m] > target) r = m - 1;
            else l = m + 1; // nums[m] <= target
        }
        res[1] = r;

        return res;
    }
}
