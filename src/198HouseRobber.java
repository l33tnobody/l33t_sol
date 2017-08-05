public class Solution {
    public int rob(int[] nums) {
        int[][] mem = new int[nums.length + 1][2];

        for(int i=1; i<=nums.length; i++) {
            mem[i][0] = Math.max(mem[i-1][0], mem[i-1][1]);
            mem[i][1] = nums[i-1] + mem[i-1][0];
        }

        return Math.max(mem[nums.length][0], mem[nums.length][1]);
    }

    // or using two vars is enough
    // int exclude = 0, include = 0;
    //
    //     for(int k=0; k<nums.length; k++) {
    //         int e = exclude, i = include;
    //
    //         exclude = Math.max(e, i);
    //         include = nums[k] + e;
    //     }
    //
    // return Math.max(exclude, include);
}
