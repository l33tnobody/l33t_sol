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
