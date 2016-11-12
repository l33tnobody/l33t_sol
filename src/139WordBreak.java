public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] table = new boolean[len+1];

        table[0]=true;

        for(int i=1; i<=len; i++) {
            for(int j=0; j<i; j++) {
                if (table[j] && wordDict.contains(s.substring(j+1-1, i-1+1))) {
                    table[i] = true;
                    break;
                }
            }
        }

        return table[len];
    }
}
