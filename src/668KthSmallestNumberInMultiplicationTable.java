// O(mlog(m*n))
// if using heap: O(mnlogn)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int c = count(m, n, mid);
            if(c < k) low = mid + 1;
            else high = mid;
        }

        return high;
    }

    private int count(int m, int n, int val) { // check how many <= v
        int res = 0;
        for(int i = 1; i <= m; i++) {
            res += Math.min(val / i, n);
        }
        return res;
    }
}
