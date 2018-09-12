// an intuitive way is making a linklist of nodes containing char and its count
// two pointer each char group in each work in words and check, but requires extra space

// two pointer in place method
class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for(String w : words) {
            if(check(S, w)) res++;
        }
        return res;
    }
    
    public boolean check(String S, String w) {
        int j = 0; // pointer of w
        for(int i=0; i<S.length(); i++) {
            if(j<w.length() && S.charAt(i) == w.charAt(j)) j++;
            else if(i > 1 && S.charAt(i) == S.charAt(i-1) && S.charAt(i-1) == S.charAt(i-2)) ; // continue, this is the stretchy part of 3 chars
            else if(i > 0 && i < S.length()-1 && S.charAt(i-1) == S.charAt(i) && S.charAt(i) == S.charAt(i+1)) ; // continue, this is the 2nd char in a sequence
            else return false;
        }
        return j == w.length(); // w has to be shorter or equal in the end
    }
}