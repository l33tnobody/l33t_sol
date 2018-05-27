// not important
class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==0) return false;

        boolean one = (n & 1) == 1;
        n>>=1;
        while(n!=0) {
            boolean newone = (n & 1) == 1;
            if(newone != !one) return false;
            one = newone;
            n>>=1;
        }
        return true;
    }
}
