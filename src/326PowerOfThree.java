public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n<=0)
            return false;
        while(true) {
            if (n==1)
                return true;
            if (n%3 != 0)
                return false;
            n/=3;
        }
        // option2:
        // return n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}
