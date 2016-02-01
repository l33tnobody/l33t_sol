public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert s!=null&&p!=null;
        int netplen=0;
        for(int i=0;i<p.length();i++)
            if(p.charAt(i)!='*') netplen++;
        if(s.length()<netplen)  return false;
        
        //remove redundant consecutive '*'
        StringBuilder sb=new StringBuilder();
        if(p.length()>0){
            sb.append(p.charAt(0));
            for(int i=1;i<p.length();i++){ 
                if(p.charAt(i-1)=='*'&&p.charAt(i)=='*') continue;
                sb.append(p.charAt(i));
            }
        }

        int i=0; int j=0;
        return isMatchRecur(s,sb.toString(),i,j);
    }

    public boolean isMatchRecur(String s, String p, int i, int j){
        if (j==p.length()) return i==s.length();
        
        if(p.charAt(j)!='*'){
            if(i==s.length()) return false;
            if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))
                return isMatchRecur(s,p,i+1,j+1);
            return false;
        }
        // p at j =='*'
        if(i==s.length()){
            return j==p.length()-1;
            /*
            j++;
            for(;j<p.length();j++){
                if(p.charAt(j)!='*')    return false;
            }
            return true;
            */
        }
        if(isMatchRecur(s,p,i,j+1)) return true;
        return isMatchRecur(s,p,i+1,j);    
        
    }
}

