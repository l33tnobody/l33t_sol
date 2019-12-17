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

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, res = 0;
        Set<Character> set = new HashSet<>();

        for (; end < s.length(); end++) {
            char c = s.charAt(end);
            if (set.contains(c)) {
                while (s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            set.add(c);
            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}