public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i=0, j=0, sum=0, minlen=Integer.MAX_VALUE;

        while(j<nums.length) {
            sum += nums[j];
            j++;

            while(sum >= s) {
                minlen = Math.min(minlen, j-i);
                sum -= nums[i];
                i++;
            }
        }

        return (minlen == Integer.MAX_VALUE) ? 0 : minlen;
    }
}
