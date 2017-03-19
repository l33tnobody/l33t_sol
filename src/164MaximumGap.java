// note numbers are non-negative integers, might not work for negative ones.
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        // Radix Sort:
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int B = 10;
        int base = 1;

        while( max/base != 0 ) {
            int[] aux = new int[nums.length]; // new order
            int[] count = new int[B]; // buckets

            for(int i=0; i<nums.length; i++) {
                count[nums[i]/base%B]++;
            }

            for(int i=1; i<count.length; i++) {
                count[i] += count[i-1]; // position in total order
            }

            for(int i=nums.length-1; i>=0; i--) { // bigger ones first to preserve order
                aux[--count[nums[i]/base%B]] = nums[i]; // index is 0 based, has to be -1 first
            }

            for(int i=0; i<nums.length; i++) {
                nums[i] = aux[i];
            }

            base *= 10;
        }

        int maxdiff = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++) {
            maxdiff = Math.max(maxdiff, nums[i] - nums[i-1]);
        }

        return maxdiff;
    }
}
