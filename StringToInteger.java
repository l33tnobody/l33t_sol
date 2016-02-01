public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str==null||str=="") return 0;
        
        boolean minus=false;
        boolean signset=false;
        int res=0;
        int i=0;
        while(i<str.length()&&Character.isWhitespace(str.charAt(i)))
            i++;
        for (;i<str.length();i++){
            char c = str.charAt(i);
            if(!(Character.isDigit(c)||c=='+'||c=='-')) break;
            if (c == '+') {
                if (signset==true) break;
                minus=false; signset=true; continue;
                
            }
            if (c == '-') {
                if (signset==true) break;
                minus=true; signset=true; continue;}
            if (Character.isDigit(c)){
                if(res>214748364||res==214748364&&(minus&&(c-'0'>7)||!minus&&(c-'0'>6))) return minus?Integer.MIN_VALUE:Integer.MAX_VALUE;
                res=res*10+(c-'0');
            }
        }
        
        return minus?res*-1:res;
    }
}
