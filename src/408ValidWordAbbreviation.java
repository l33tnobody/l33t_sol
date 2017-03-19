public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0, j=0;

        while (i < word.length() && j < abbr.length()) {
            char c = abbr.charAt(j);
            if (Character.isLetter(c)) {
                if (word.charAt(i) != c) return false;
                i++;
                j++;
            } else {
                if (c == '0') return false;

                int val = 0;
                while (Character.isDigit(c)) {
                    val = Character.getNumericValue(c) + 10*val;
                    j++;
                    if (j >= abbr.length()) break;
                    c = abbr.charAt(j);
                }
                i += val;
            }
        }

        if (i == word.length() && j == abbr.length()) return true;

        return false;
    }
}

// a more concise implementation:

public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') { // notice the number beginning with 0 should result in false including 0
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
