public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i=1; i<nums.length; i++){
            int a = nums[i];
            if (a<0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max*a, a);
            min = Math.min(min*a, a);
            res = Math.max(res, max);
        }
        return res;
    }
}
