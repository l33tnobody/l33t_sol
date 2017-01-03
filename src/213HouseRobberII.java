public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n==1)   return nums[0]; // 1 house cannot form a circle

        return Math.max(robhelper(0, n-2, nums), robhelper(1, n-1, nums));
    }

    private int robhelper(int lo, int hi, int[] nums) {
        int exclude = 0, include = 0;

        for(int k=lo; k<=hi; k++) {
            int e = exclude, i = include;

            exclude = Math.max(e, i);
            include = nums[k] + e;
        }

        return Math.max(exclude, include);
    }
}
