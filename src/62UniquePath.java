public class Solution {
    public int uniquePaths(int m, int n) {
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

// or better:
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res= new int[m+1][n+1];
        res[0][1]=1;
        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                res[i][j] += res[i-1][j] + res[i][j-1];
            }
        }
        return res[m][n];
    }
}
