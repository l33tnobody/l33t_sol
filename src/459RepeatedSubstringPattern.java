// O(n^3) there is kmp trick to this as well.
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len < 2) return false;
        
        for(int plen = len/2; plen >= 1; plen--) {
            if(len % plen != 0) continue;
            if(able(s.substring(0, plen), s)) return true;
        }
        
        return false;
    }
    
    private boolean able(String p, String t) {
        for(int i = 0; i < t.length(); i += p.length()) {
            int k = i;
            for(int j=0; j<p.length(); j++, k++) {
                if(p.charAt(j) != t.charAt(k)) return false;
            }
        }
        
        return true;
    }
}