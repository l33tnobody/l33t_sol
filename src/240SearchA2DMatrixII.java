public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;

        int i=0, j=n-1;
        while(i<m && j>=0){
            int num = matrix[i][j];
            if (num == target){
                return true;
            } else if (num < target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
