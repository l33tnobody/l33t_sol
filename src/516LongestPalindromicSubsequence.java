public class Solution {
    private int max = 0;

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
