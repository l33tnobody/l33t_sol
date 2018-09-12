/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n/2; i++) {
            int[] t = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = t;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
/*
 * counter clockwise rotate:
 * first swap the symmetry and then reverse up down
 * 1 2 3     1 4 7     3 6 9
 * 4 5 6  => 2 5 8  => 2 5 8
 * 7 8 9     3 6 9     1 4 7
*/


// ---------- scratch this: not good
public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix==null) return;
        int n=matrix[0].length;
        for(int layer=0;layer<n/2;layer++){
            int last=n-1-layer;
            for(int i=layer;i<last;i++){
                int offset=i-layer;
                int top=matrix[layer][i];
                matrix[layer][i]=matrix[last-offset][layer];
                matrix[last-offset][layer]=matrix[last][last-offset];
                matrix[last][last-offset]=matrix[layer+offset][last];
                matrix[layer+offset][last]=top;
            }
        }
    }
}
