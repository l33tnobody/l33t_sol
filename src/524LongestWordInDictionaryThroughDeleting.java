class Solution {
    public String findLongestWord(String s, List<String> d) {
        // sorting the dictionary based on length decreasing will cost nlogn, when the dictionary is huge making it slower than just go through n:
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for(char c : s.toCharArray()) {
                if (i == dictWord.length()) break;
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
