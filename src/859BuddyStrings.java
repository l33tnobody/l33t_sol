class Solution {
    public boolean buddyStrings(String A, String B) {
        int a = -1, b = -1; // indexes of first and second different chars
        
        if(A.length() != B.length()) return false;
        if(A.length() < 2) return false;
        
        int[] count = new int[26]; // in case A equals B, need to check dup chars
        for(int i=0, j=0; i<A.length(); i++, j++) {
            count[A.charAt(i) - 'a']++;
            
            if(A.charAt(i) == B.charAt(j)) continue;
            
            if(a == -1) a = i;
            else if(b == -1) b = i;
            else return false;
        }
        
        if(a == -1) { // String A and B are identical, check if any dup chars
            for(int cnt : count) if(cnt >= 2) return true;
        } else if(b != -1 && A.charAt(a) == B.charAt(b) && A.charAt(b) == B.charAt(a)) return true;
        
        return false;
    }
}