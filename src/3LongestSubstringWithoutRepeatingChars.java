public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, maxlen=0;
        Map<Character, Boolean> exist = new HashMap<>();

        while(j<s.length()) {
            if(exist.containsKey(s.charAt(j)) && exist.get(s.charAt(j)) == true) {
                maxlen = Math.max(maxlen, j-i);
                while(s.charAt(i) != s.charAt(j)) {
                    exist.put(s.charAt(i), false);
                    i++;
                }
                i++;
                j++;
            } else {
                exist.put(s.charAt(j), true);
                j++;
            }
        }
        maxlen = Math.max(maxlen, s.length()-i);

        return maxlen;
    }
}
