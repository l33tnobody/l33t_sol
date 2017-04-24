public class Solution {
    private int lo = 0, maxlen = 0;

    public String longestPalindrome(String s) {

        for(int i=0; i<s.length(); i++) {
            expand(s, i, i); // expand odd length
            expand(s, i, i+1); // expand even length
        }

        return s.substring(lo, lo + maxlen);
    }

    private void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if (j-i-1 > maxlen) {
            lo = i+1;
            maxlen = j-i-1;
        }
    }
}

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int len = s.length();
        boolean[][] map = new boolean[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<=i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || map[j+1][i-1])) {
                    map[j][i] = true;
                }

                if (map[j][i] && i-j+1 > res.length()) {
                    res = s.substring(j, i+1);
                }
            }
        }

        return res;
    }
}
