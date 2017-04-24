public class Solution {
    public String shortestPalindrome(String s) {
        String sr = new StringBuilder(s).reverse().toString();

        String snew = s + "#" + sr;
        int[] lps = getLPS(snew); // LPS: longest proper prefx that is also suffix
        int index = lps[lps.length - 1];

        return sr.substring(0, sr.length() - index) + s; // reversed part + original s
    }

    public int[] getLPS(String s) {
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int index = 0;
        int i = 1;

        while(i < s.length()) {
            if(s.charAt(i) == s.charAt(index)) {
                index++;
                lps[i] = index;
                i++;
            } else {
                if(index != 0) {
                    index = lps[index-1];
                } else { // index == 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}

// http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
// https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation

// Time Limit Exceeded: O(n^2)
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.equals("")) return s;

        int j = getPalindromeEndIndex(s);
        String prefix = new StringBuilder(s.substring(j+1)).reverse().toString();
        return prefix + s;
    }

    private int getPalindromeEndIndex(String s) {
        int j = s.length() - 1;
        while(j > 0) {
            int ip = 0;
            int jp = j;
            while(ip < jp && s.charAt(ip) == s.charAt(jp)) {
                ip++; jp--;
            }
            if (ip >= jp) break;
            j--;
        }
        return j;
    }
}
