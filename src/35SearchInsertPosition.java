// normal binary search: l is the insert position
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n -1;

        while(l <= r) {
            int m = l + (r - l)/2;
            if(target == nums[m]) return m;
            if(target < nums[m])  r = m - 1;
            else l = m + 1;
        }
        return l;
    }
}

//also works
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m])
                return m;
            if (target < nums[m])
                r = m;
            else
                l = m + 1;
        }
        return r;
    }
}