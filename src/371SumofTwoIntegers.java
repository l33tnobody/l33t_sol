// not important, do not need to review, just fun bit trick
class Solution {
    public int getSum(int a, int b) {
        //                         sum,  carry
        return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }
}
