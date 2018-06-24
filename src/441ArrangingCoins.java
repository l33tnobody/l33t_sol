// just for fun: the floor search
class Solution {
    public int arrangeCoins(int n) {
        int l = 1, h = n;

        while(l <= h ) {
            long mid = l + (h - l) / 2;
            long sum = (1 + mid)* mid / 2;
            if(sum == n) return (int)mid;
            if(sum < n) l = (int)mid + 1;
            else h = (int)mid - 1;
        }

        return h; // return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2); solution to the formula
    }
}
