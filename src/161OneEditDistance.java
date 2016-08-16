public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false; //filter out 0 distance

        int slen = s.length();
        int tlen = t.length();
        int difflen = Math.abs(slen - tlen);

        if (difflen>1) return false;

        int i=0, j=0, diffcount=0;

        while(i<slen && j<tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (++diffcount>1) return false;

                if (slen==tlen) { i++; j++;} // can only replace
                else if (slen>tlen) {i++;}  // can only delete current one from s, or insert a blank to t
                else {j++;}
            }
        }

        return true;
    }
}

public class Solution {
    public boolean isOneEditDistance(String s, String t) {

        int slen = s.length();
        int tlen = t.length();
        int difflen = Math.abs(slen - tlen);

        if (difflen>1) return false;

        int i=0, j=0, diffcount=0;

        while(i<slen && j<tlen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                if (++diffcount>1) return false;

                if (slen==tlen) { i++; j++;} // can only replace
                else if (slen>tlen) {i++;}  // can only delete current one from s, or insert a blank to t
                else {j++;}
            }
        }

        if (diffcount == 0)
            diffcount += difflen;

        return diffcount==1;
    }
}
