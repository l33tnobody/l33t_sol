// to optimize space wise: only need to memorize dp[4][n][len] where len is 3: dp process only look back to len-1, len-2
class Solution {
    public int countPalindromicSubsequences(String S) {
        int n = S.length();
        int[][][] dp = new int[4][n][n]; // defined as the palindrome that ends on the char 0..4 a..a, b..b, etc
        int mod = 1000000007;
        
        char[] chs = S.toCharArray();
        
        for(int distance = 0; distance < n; distance++) {
            for(int i = 0; i + distance < n; i++) {
                int j = i + distance;
                for (int k = 0; k < 4; ++k) {
                    char c = (char) ('a' + k);
                    if (j == i) {
                        if (chs[i] == c) dp[k][i][j] = 1; // else 0
                    } else {
                        if (chs[i] != c) dp[k][i][j] = dp[k][i+1][j];
                        else if (chs[j] != c) dp[k][i][j] = dp[k][i][j-1];
                        else { // S[i] == S[j] == c
                            dp[k][i][j] = 2;
                            if(distance > 1) {
                                for(int ch=0; ch<4; ch++) {
                                    dp[k][i][j] += dp[ch][i+1][j-1];
                                    /*note: if outer a....a and add for inner a..a, only add results for aa..aa but not the inner a..a
                                      the reason is that inner a..a will duplicate other inner inner combination with outter a..a
                                    */
                                    dp[k][i][j] %= mod;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for (int k = 0; k < 4; ++k) {
          res += dp[k][0][n-1];
          res %= mod;
        }
        return res;
    }
}

// O(n^3) due to the low and high search
// can be optimized using an array next[4][len] and prev[4][len] for each char (a, b, c, d) to make it O(1) and
// turn the overall time complexity down to O(n^2)
class Solution {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];
        int mod = 1000000007;
        
        char[] chs = S.toCharArray();
        for(int i = 0; i < len; i++) dp[i][i] = 1;

        for(int distance = 1; distance < len; distance++) {
            for(int i = 0; i + distance < len; i++) {
                int j = i + distance;
                if(chs[i] == chs[j]) {
                    int low = i + 1;
                    int high = j - 1;
                    while(low <= high && chs[low] != chs[j]) low++; // O(n) here
                    while(low <= high && chs[high] != chs[j]) high--;
                    
                    if(low > high) {
                        // consider the string from i to j is "a...a" "a...a"... where there is no character 'a' in between
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2; // aa and a
                    } else if(low == high) {
                        // consider the string from i to j is "a...a...a" where there is only one character 'a' in between
                        dp[i][j] = dp[i + 1][j - 1]  * 2 + 1; // aa since a in the middle has already been counted
                    } else { // low < high
                        // consider the string from i to j is "a...a...a...a" where there are at least two character 'a' in between
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1]; 
                    }
                    
                } else { // chs[i] != chs[j] no addition
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }
        
        return dp[0][len - 1];
    }
}