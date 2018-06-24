// or simply this:
public class Solution {
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}

// slightly faster
class Solution {
    public int firstUniqChar(String s) {
        int[] indexes = new int[26];
        for(int i=0; i<26; i++) {
            indexes[i] = -1; // meaning not seen, since default 0 will collide with index 0  
        }
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(indexes[c - 'a'] == -1) {
                indexes[c - 'a'] = i;
            } else indexes[c - 'a'] = -2;
        }
        
        int res = Integer.MAX_VALUE;
        for(int i : indexes) {
            if(i < 0) continue;
            res = Math.min(res, i);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}