// O(n^2 + m)
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>();
        for(String str : wordDict) dict.add(str);

        int len = s.length();
        boolean[] table = new boolean[len+1];

        table[0]=true;

        for(int i=1; i<=len; i++) {
            for(int j=0; j<i; j++) {
                if (table[j] && dict.contains(s.substring(j+1-1, i-1+1))) {
                    table[i] = true;
                    break;
                }
            }
        }

        return table[len];
    }
}

// or: for each i iterate through words, O(n*m) m being number of words in the dict
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] table = new boolean[len+1];

        table[0]=true;

        for(int i=1; i<=len; i++) {
            String substr = s.substring(0, i);
            for(String word : wordDict) {
                if (substr.endsWith(word) && table[i-word.length()]) {
                    table[i] = true;
                    break;
                }
            }
        }

        return table[len];
    }
}
