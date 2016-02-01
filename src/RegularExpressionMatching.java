public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert s!=null&&p!=null;
        
        int i=0; int j=0;
        return isMatchRecur(s,p,i,j);
    }
    
    public boolean isMatchRecur(String s, String p, int i, int j){
        if (j==p.length()) return i==s.length();
        
        assert p.charAt(j)!='*';
        //no '*' following
        if (j==p.length()-1 || p.charAt(j+1)!='*') { 
            if(i==s.length()) return false;
            if(!(p.charAt(j)==s.charAt(i)||(p.charAt(j)=='.')))
                return false;
            return isMatchRecur(s,p,i+1,j+1);
        }
        
        //'*' follows next in p
        while((i<s.length()&&p.charAt(j)==s.charAt(i)) || p.charAt(j)=='.'&&i<s.length()){
            if (isMatchRecur(s,p,i,j+2)) return true;
            return isMatchRecur(s,p,i+1,j);
        }
        return isMatchRecur(s,p,i,j+2);
    }
}
