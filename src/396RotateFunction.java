// https://leetcode.com/problems/rotate-function/discuss/87853/Java-O(n)-solution-with-explanation
// recursion: F(k) = F(k-1) + sum - nBk[0]
class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i]; // F(0)
            sum += A[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + sum - len * A[i];
            max = Math.max(max, F);
        }
        return max;   
    }
}