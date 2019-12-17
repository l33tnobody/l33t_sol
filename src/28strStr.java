public class Solution {
    public int strStr(String haystack, String needle) {
        // if (haystack.length() < needle.length()) return -1; // not needed

        for(int i=0; i<haystack.length() - needle.length() + 1; i++) {
            int j=0;
            for(; j<needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i+j)) break;
            }

            if(j == needle.length()) return i;
        }

        return -1;
    }
}

// KMP just for fun, see geeksforgeeks
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;

        int lps[] = getLPS(needle);
        int i=0, j=0;
        while(i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == needle.length()) {
                return i - j;
                // j = lps[j - 1]; to continue search
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                 // mismatch after j matches
                if (j != 0 ) {
                    j = lps[j-1]; // don't match 0 ... lps[j-1]-1, they will match according to LPS, a.k.a. Longest Proper Prefix this also Suffix
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public int[] getLPS(String needle) {
        int[] lps = new int[needle.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while(i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
