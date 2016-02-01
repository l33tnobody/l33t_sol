public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diffBits=0;
        while(n!=m){
            n = n>>1;
            m = m>>1;
            diffBits++;
        }
        return n<<diffBits;
    }
}
