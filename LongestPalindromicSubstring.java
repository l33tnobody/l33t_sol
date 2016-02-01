public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null||s.length()==0) return "";
        int[] fromto = new int[2];
        fromto[0] = 0;
        fromto[1] = 1;  //default longest first char
        
        for(int i=0; i<s.length(); i++){
            int[] res = expand(s,i,i);
            if(better(res, fromto)){
                fromto=res;
            }
            res = expand(s,i,i+1);
            if(better(res, fromto)){
                fromto=res;
            }
        }
        
        return s.substring(fromto[0], fromto[1]);
    }
    
    int[] expand(String s, int c1, int c2){
        int l=c1;
        int h=c2;
        int[] res = new int[2];
        while(l>=0 && h<s.length() && s.charAt(l)==s.charAt(h)){
            l--;
            h++;
        }
        res[0] = l+1;
        res[1] = h;
        return res;
    }
    
    boolean better(int[] A, int[] B){
        return A[1]-A[0] > B[1]-B[0]? true:false;
    }
}
