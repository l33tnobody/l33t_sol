class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int depth = m, width = n;

        for(int[] op : ops) {
            // can also count the max number by count how many times added by ops except from the zero ones if zero is possible in ops
            depth = Math.min(depth, op[0]); // non zero: positive integers, if it can be zero, then zero on depth or width needs to be skipped
            width = Math.min(width, op[1]);
        }

        return depth * width;
    }
}
