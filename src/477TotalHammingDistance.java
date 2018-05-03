// For each bit position 1-32 in a 32-bit integer,
// we count the number of integers in the array which have that bit set.
// if there are n integers in the array and k of them have a particular bit set and (n-k) do not,
// then that bit contributes k*(n-k) hamming distance to the total.

class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        int mask = 1;

        for(int i=0; i<32; i++) {
            int count = 0;
            for(int j : nums) {
                if((j & mask) != 0) count++;
            }
            total += count*(n-count);
            mask <<= 1;
        }
        return total;
    }
}
