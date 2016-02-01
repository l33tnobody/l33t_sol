public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //m-1+n-1 pick m-1 = m+n-2 ! / (m-1 ! * n-1 !)
        int[][] res= new int[m][n];
        res[0][0]=1;
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++){
                res[i][j] += (i-1<0? 0:res[i-1][j]) + (j-1<0? 0:res[i][j-1]);
            }
            
        return res[m-1][n-1];
    }
}
