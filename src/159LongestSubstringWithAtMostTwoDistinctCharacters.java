public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, len = 0, count = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) == 1) { // new char
                count++;
                while (count>2) { // slide window from left
                    char schar = s.charAt(start);
                    map.put(schar, map.get(schar) - 1);
                    if (map.get(schar) == 0) count--;
                    start++;
                }
            }
            len = Math.max(len, i-start+1);
        }

        return len;
    }
}
