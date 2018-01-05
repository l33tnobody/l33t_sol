class Solution {
    // the key is that a circle must be formed with in-degree equals out-degree
    public int arrayNesting(int[] nums) {
        int max = 0; // starting from 0 makes sense for empty array

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == -1) continue; // visited if -1

            int j = i, count = 0;
            while(nums[j] != -1) {
                count++;
                int k = nums[j];
                nums[j] = -1;
                j = k;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
