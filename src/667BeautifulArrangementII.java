// just for fun:
// The requirement of k distinct distance can be achieved from 1, 2, ..., k+1 (<= n), with the following strategy:
// 1, k+1, 2, k, 3, k-1 ...;
// The distance of this sequence is k, k-1, k-2, ..., 2, 1

class Solution {
    public int[] constructArray(int n, int k) {
        int l = 1, r = k+1;
        int[] res = new int[n];
        int i = 0;
        while (l <= r) {
            res[i++] = l++;
            if (l <= r) res[i++] = r--;
        }
        
        for (int j = k+2; j <= n; j++)
            res[i++] = j;
        return res;
    }
}