public class Solution {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<=1)    return 1;
        int iMinus2=1;
        int iMinus1=1;
        int ires=0;
        for(int i=2; i<=n; i++){
            ires=iMinus1+iMinus2;
            iMinus2=iMinus1;
            iMinus1=ires;
        }
        return ires;
    }
}
