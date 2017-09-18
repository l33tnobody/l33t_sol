class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int step=0; step<n; step++) {
            for(int i=0; i+step<n; i++) {
                int j = i + step;
                if(s.charAt(j) == s.charAt(i) && (step <= 2 || dp[i+1][j-1])) {
                    sum++;
                    dp[i][j] = true;
                }
            }
        }

        return sum;
    }
}

// extending from the middle
class Solution {
    private int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}
