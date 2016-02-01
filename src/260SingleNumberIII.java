public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums){
            diff ^= num;
        }

        int b = 1;
        while((diff & b) == 0){
            b<<=1;
        }

        // Pass 2 :
        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & b) == 0) { // the b bit is 0
                res[0] ^= num;
            } else { // the b bit is 1
                res[1] ^= num;
            }
        }

        return res;
    }
}
