class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        for(int s = 0, e = 0; s < nums.length; s++) {
            if(nums[s] == 0) continue;

            e = s + 1;
            while(e < nums.length && nums[e] == 1) e++;
            max = Math.max(max, e - s);
            s = e - 1;
        }

        return max;
    }
}

// or use a counter:
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else count = 0;
        }

        return result;
    }
}
