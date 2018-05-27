class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = low + ((high - low) >>> 1);

            long t = mid * mid;
            if (t == num) {
                return true;
            } else if (t < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }

        return false;
    }
}
