// Last Set Bit dp
// Last set bit is the rightmost set bit. (least significant bit)
// Setting that bit to zero with the bit trick, x &= x - 1

public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i=1; i<=num; i++) {
            res[i] = res[ i & (i-1) ] + 1;  // #bits = #(bits - rightmost bit) + 1
        }
        return res;
    }
}
