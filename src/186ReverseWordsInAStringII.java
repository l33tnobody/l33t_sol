public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int l=0, r=0;
        for(; r<s.length; r++){
            if (s[r] == ' '){
                if (r>l) {
                    reverse(s, l, r-1);
                }
                l=r+1;
            }
        }

        if (r>l) {
            reverse(s, l, r-1);
        }
    }

    public void reverse(char[] s, int l, int r){
        while(l<r) {
            char lc = s[l];
            s[l] = s[r];
            s[r] = lc;
            l++;
            r--;
        }
    }
}
