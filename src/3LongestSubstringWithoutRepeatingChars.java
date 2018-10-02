// only need to remember the last appearing index of chars
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0, end=0, maxlen=0;
        Map<Character, Integer> map = new HashMap<>(); // from char to the last appearing index
        
        for(; end < s.length(); end++) {
            char c = s.charAt(end);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxlen = Math.max(maxlen, end - start + 1);
        }
        
        return maxlen;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, maxlen=0;
        Map<Character, Boolean> exist = new HashMap<>(); // can use of array of some size

        while(j<s.length()) {
            if(exist.containsKey(s.charAt(j)) && exist.get(s.charAt(j)) == true) {
                maxlen = Math.max(maxlen, j-i);
                while(s.charAt(i) != s.charAt(j)) {
                    exist.put(s.charAt(i), false); // or delete the key from hashmap
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
