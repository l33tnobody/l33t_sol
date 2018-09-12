// two pointers
// * for window (5, 2, 6), when 6 is introduced, it add 3 new subarray:
//  *       (6)
//  *    (2, 6)
//  * (5, 2, 6)

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i=0, j=0, n=nums.length;
        long p = 1;
        int res = 0;
        
        while(j < n) {
            p *= nums[j];
            while(i <= j && p >= k) { // note the i<=j condition
                p /= nums[i++];
            }
            res += j-i+1;
            j++;
        }
        return res;
    }
}