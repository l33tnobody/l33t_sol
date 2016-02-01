public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null) return 0;
        int last=s.length()-1;
        int len=0;
        for(;last>=0 && s.charAt(last)==' ';last--);
        for(;last>=0 && s.charAt(last)!=' ';last--) len++;
        return len;
    }
}
