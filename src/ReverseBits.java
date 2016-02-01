public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        int count=31;

        while(n!=0){ //only reverse ones
            if((n&1) == 1){
                res += 1<<count;
            }
            count--;
            n = n>>>1; // sign independent
        }

        return res;
    }
}
