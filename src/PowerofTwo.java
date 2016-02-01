public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;
        return (n&(n-1)) == 0;
    }
}

// no n&(n-1) trick:
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0)
            return false;

        while ((n&1)==0){
            n = n>>1;
        }
        return (n>>1)==0;
    }
}
