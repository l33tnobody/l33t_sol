public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=needle.length();
        if(m==0) return haystack;
        
        int n=haystack.length();
        
        int j=m-1;
        int i=0;
        while(j<n){
            int p1=i;
            int p2=0;
            while(p2<m){
                if(haystack.charAt(p1)==needle.charAt(p2)){
                    p1++;
                    p2++;
                }else
                    break;
            }
            if(p2==m) return haystack.substring(i);
            else {
                i++;
                j++;
            }
        }
        return null;
    }
}
