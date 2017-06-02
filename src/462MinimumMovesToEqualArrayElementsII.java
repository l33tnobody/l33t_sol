public class Solution {
    public int minMoves2(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int i=0;
        int j=nums.length - 1;
        while(i<j) {
            res += nums[j--] - nums[i++];
        }
        return res;
    }
}
