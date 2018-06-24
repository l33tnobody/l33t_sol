class Solution {
    public int mySqrt(int x) {
        long l = 0, r = (long)x; // fun: l can be 1 as well
        while(l <= r){
            long mid = (l + r) / 2;
            long t = mid * mid;
            if(t == x) {
                return (int)mid;
            } else if (t < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return (int) r; // return the smaller one which is r: m - 1 when m*m too big or l becomes m + 1 which is too big
    }
}
