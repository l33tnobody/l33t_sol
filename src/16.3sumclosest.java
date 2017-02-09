public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = 0;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int tempsum = nums[i] + nums[j] + nums[k];
                int newdiff = Math.abs(tempsum - target);

                if (newdiff < diff) {
                    diff = newdiff;
                    sum = tempsum;
                }

                if (diff == 0) return tempsum;

                if (tempsum > target) k--;
                else j++; // tempsum < target
            }
        }

        return sum;
    }
}
