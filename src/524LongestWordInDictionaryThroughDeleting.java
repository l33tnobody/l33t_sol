// similar to a binary search problem of search pattern?

// with some more optimization:
class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            // skip if dictWord.length() > s.length()
            if (dictWord.length() > s.length())
                continue;
            // skip if dictWord.length() < longest.length(), shorter ones cannot be the
            // answer
            if (dictWord.length() < longest.length())
                continue;

            int i = 0;
            int j = 0;
            for (char c : s.toCharArray()) {
                if (i == dictWord.length())
                    break;
                // can also skip here if not enough chars left in s
                if (s.length() - j < dictWord.length() - i)
                    break;

                if (dictWord.charAt(i) == c) { // need to keep aware of the index is valid not over bound, using above
                                               // line, and early terminate on match
                    i++;
                }
                j++;
            }

            if (i == dictWord.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }
}

class Solution {
    public String findLongestWord(String s, List<String> d) {
        // sorting the dictionary based on length decreasing will cost nlogn, when the dictionary is huge making it slower than just go through n:
        String longest = "";
        for (String dictWord : d) {
            // skip if dictWord.length() > s.length()
            int i = 0;
            for(char c : s.toCharArray()) {
                if (i == dictWord.length()) break;
                // can also skip here if not enough chars left in s
                if(dictWord.charAt(i) == c) { // need to keep aware of the index is valid not over bound, using above line, and early terminate on match
                    i++;
                }
            }

            if (i == dictWord.length() && dictWord.length() >= longest.length())
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }
}