public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m+n != s3.length())   return false;

        boolean[][] dptable=new boolean[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 && j==0)
                    dptable[i][j]=true;
                else if(i==0)
                    dptable[i][j] = (s2.charAt(j-1) == s3.charAt(j-1) && dptable[i][j-1]);
                else if(j==0)
                    dptable[i][j] = (s1.charAt(i-1) == s3.charAt(i-1) && dptable[i-1][j]);
                else
                    dptable[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dptable[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dptable[i][j-1]);
            }
        }

        return dptable[m][n];
    }
}
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        if(m + n != s3.length()) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i=1; i<m+1; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]) dp[i][0] = true;
        }

        for(int j=1; j<n+1; j++) {
            if(s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1]) dp[0][j] = true;
        }

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if( (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j])
                  || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]))
                    dp[i][j] = true;
            }
        }

        return dp[m][n];
    }
}


// or optionally recursive top down:
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new int[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, int[][] valid) {
        if(valid[i][j] == -1) return false; // cache valid result starting from i and j for c1 and c2
        if(valid[i][j] == 1) return true;
        if(k == c3.length) return true;
        boolean isValid =
            (i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, valid)) ||
            (j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, valid));
        valid[i][j] = isValid ? 1 : -1;

        return isValid;
    }
}
