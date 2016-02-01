public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        String path="";
        rtiprecur(s, 0, 0, path, res);
        return res;
    }
    
    private void rtiprecur(String s, int si, int pn, String path, ArrayList<String> res){
        if(s.length()-si > 3*(4-pn) || s.length()-si < (4-pn))  return;
        
        if(si==s.length() && pn==4){
            //resize -1 to remove '.'
            res.add(path.substring(0,path.length()-1));
            return;
        }
        
        int num=0;
        for(int i=si; i<si+3 && i<s.length(); i++){
            num=num*10+(s.charAt(i)-'0');
            
            if(num>255) break;
            path+=s.charAt(i);
            rtiprecur(s, i+1, pn+1, path+'.', res);
            
            if(num==0) break;   //no 0xx
        }
    }
}
