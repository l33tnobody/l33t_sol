class Solution {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        for(int l=0; l<=n-1; l++) {
            for(int i=0; i+l<n; i++) {
                int j = i+l;
                String substr = s.substring(i, j+1);
                dp[i][j] = substr; // no compression at first

                if(l < 4) { // substring cannot be shortened, l == len - 1
                    continue;
                }

                // otherwise might be possible to be shortened
                for(int k=i; k<j; k++) { // divide and combine current substring into two halves and to find the shortest:
                    if(dp[i][k].length() + dp[k+1][j].length() < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k+1][j];
                    }
                }

                // try shorten substr as a whole with repeating pattern
                for(int k=0; k<substr.length()/2; k++) {
                    String repeatstr = substr.substring(0, k+1);
                    int times = repeat(repeatstr, substr);
                    if (times != -1) {
                        String ss = times + "[" + dp[i][i+k] + "]"; // note here: it is not "repeatstr" in the "[ ]" but dp[i][i+k] since repeatstr itself might be shortened.
                        if(ss.length() < dp[i][j].length()) dp[i][j] = ss;
                    }
                }
            }
        }

        return dp[0][n-1];
    }

    private int repeat(String pat, String whole) {
        if (whole.length() % pat.length() != 0) return -1;
        int times = 1;
        for(int i=pat.length(); i<whole.length(); i+=pat.length()) {
            String sub = whole.substring(i, i+pat.length());
            if (!sub.equals(pat)) return -1;
            times++;
        }
        return times;
    }
}
