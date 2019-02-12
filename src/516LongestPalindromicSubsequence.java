// sub problem is max of from to, step from small to large
public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.equals("")) return 0;

        int n = s.length();
        int[][] mem = new int[n][n];

        for(int step=0; step<n; step++) {
            for(int i=0; i+step<n; i++) {
                if(step == 0) {
                    mem[i][i] = 1;
                    continue;
                }
                int j = i+step;
                if (s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = mem[i+1][j-1] + 2; // if step == 1 mem[i+1][j-1] is 0 from init
                } else {
                    mem[i][j] = Math.max(mem[i][j-1], mem[i+1][j]);
                }
            }
        }

        return mem[0][n-1];
    }
}





public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.equals("")) return 0;

        int n = s.length();
        int[][] mem = new int[n][n];

        for(int j=0; j<n; j++) {
            for(int i=j; i>=0; i--) {
                if (i == j) {
                    mem[i][j] = 1;
                    continue;
                }
                // if current length is 2 and s.charAt(i) == s.charAt(j), mem[i+1][j-1] == 0 from init

                if (s.charAt(i) == s.charAt(j)) {
                    mem[i][j] = mem[i+1][j-1] + 2;
                } else {
                    mem[i][j] = Math.max(mem[i][j-1], mem[i+1][j]);
                }
            }
        }

        return mem[0][n-1];
    }
}
