public class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int i : nums) {
            if (min > i) min = i;
        }

        int res = 0;
        for(int i : nums) {
            res += i - min;
        }
        return res;
    }
}
