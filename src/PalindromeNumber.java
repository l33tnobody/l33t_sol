public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x<0) return false;
        int div=1;
        while(x/div>=10) div*=10;
        while(x!=0){
            int l=x/div;
            int r=x%10;
            if(l!=r) return false;
            x%=div;
            x/=10;
            div/=100;
        }
        return true;
    }
}
