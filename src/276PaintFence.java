public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int lasttwodiff = k * (k - 1);
        int lasttwosame = k;

        for(int i=3; i<=n; i++) {
            int temp = lasttwodiff;
            lasttwodiff = (lasttwodiff + lasttwosame) * (k-1);
            lasttwosame = temp;
        }

        return lasttwodiff + lasttwosame;
    }
}
