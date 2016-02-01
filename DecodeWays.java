public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0)   return 0;   //stupid test case of ""
        
        int pre0=1, pre1=1;
        for(int i=0; i<s.length(); i++){
            int temp=0;
            if(isValid(s,i,1))  temp+=pre1;
            if(isValid(s,i,2))  temp+=pre0;
            pre0=pre1;
            pre1=temp;
        }
        return pre1;
    }
    
    private boolean isValid(String s, int i, int len){
        if(len==1){
            int d=s.charAt(i)-'0';
            if(d>=1&&d<=9)  return true;
        }else if(len==2){
            if(i-1>=0){
                int num = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
                if(num>=10&&num<=26)    return true;
            }
        }
        
        return false;
    }
}
