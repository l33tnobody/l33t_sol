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

// A verbose LRU solution of the special case with only two cached elements of pointers
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {        
        int max = 0;
        int p1 = -1, p2 = -1; // last indexes of two chars, assume p1 is always preceeding p2
        int start = 0;
        
        char[] sa = s.toCharArray();
        for(int i=0; i<sa.length; i++) {
            if(p1 == -1 && p2 == -1) { // first ever char
                p1 = i;
            } else if (p2 == -1 && sa[i] == sa[p1]) { // only one char appears so far
                p1 = i;
            } else if (p2 == -1) { // the second char appears
                p2 = i;
            } else if (sa[i] == sa[p2]) { // the second char continues
                p2 = i;
            } else if (sa[i] == sa[p1]) { // the first char appears lately so switch the two pointer nominally to guarantee p1 is before p2, so far the string does not have a third char
                p1 = p2;
                p2 = i;
            } else { // the third char appears that does not equal to either char at p1 nor p2, so advance start pointer to p1+1 to guarantee the current substring is still consisting of no more than two distinct chars
                start = p1 + 1;
                p1 = p2;
                p2 = i;
            }
            
            max = Math.max(max, i - start + 1);
        }
        
        return max;
    }
}