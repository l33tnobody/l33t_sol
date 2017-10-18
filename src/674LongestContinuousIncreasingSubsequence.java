class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0, cur = 0;
        int prev = Integer.MIN_VALUE;

        for(int n : nums) {
            if(n > prev) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
            prev = n;
        }

        return max;
    }
}
