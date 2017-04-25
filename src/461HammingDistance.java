public class Solution {
    public int hammingDistance(int x, int y) {
        int hd = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) hd++;
            x >>>= 1;
            y >>>= 1;
        }
        return hd;
    }
}

public class Solution {
    public int hammingDistance(int x, int y) {
        int hd = 0;
        int xor = x ^ y;
        while (xor != 0) {
            hd += (xor & 1);
            xor >>>= 1;
        }
        return hd;
    }
}
