class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
        //                only one 1 and at the positions of power of 4s
    }
}
