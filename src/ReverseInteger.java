public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res=0;
        int lastdigit=0;
        
        int temp=Math.abs(x);
        
        while(temp>0){
            lastdigit=temp%10;
            res=res*10+lastdigit;
            temp/=10;
        }
  
        if(x<0) res=res*-1;
        
        return res;
    }
}
