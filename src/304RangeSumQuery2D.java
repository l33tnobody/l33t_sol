// https://leetcode.com/course/chapters/leetcode-101/range-sum-query-2d-immutable/
public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        dp = new int[matrix.length + 1][matrix[0].length + 1]; // padding
        for (int r=0; r<matrix.length; r++){
            for (int c=0; c<matrix[0].length; c++){
                dp[r+1][c+1] = dp[r][c+1] + dp[r+1][c] + matrix[r][c] - dp[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (dp==null)
            return 0;
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
