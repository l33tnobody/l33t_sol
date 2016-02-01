public class Solution {
    /*  https://leetcode.com/discuss/64962/java-python-one-pass-solution-easy-to-understand
        n = xyzdabc, 3 scenarios:
        (1) xyz * 1000                     if d == 0
        (2) xyz * 1000 + abc + 1           if d == 1
        (3) xyz * 1000 + 1000              if d > 1
    */
    public int countDigitOne(int n) {
        if (n<=0)
            return 0;

        int result=0;
        int d=1, running = n;

        while(running>0){
            int digit = running % 10;
            running /= 10;
            result += running*d;
            if (digit == 1)
                result += n % d + 1;
            else if (digit > 1)
                result += d;
            d *= 10;
        }

        return result;
    }
}
