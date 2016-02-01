public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum+=i;

        // n == nums.length, length for array is already built in, O(1) access.
        int n = nums.length;
        int sumAll = (0+n)*(n+1)/2;
        return (sumAll-sum);
    }
}
