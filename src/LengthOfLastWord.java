public class Solution {
    public int lengthOfLastWord(String s) {
        int last=s.length()-1;
        int len=0;
        for(;last>=0 && s.charAt(last)==' ';last--);
        for(;last>=0 && s.charAt(last)!=' ';last--) len++;
        return len;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.split(" ");
        if(res.length == 0) return 0;
        return res[res.length - 1].length();
    }
}