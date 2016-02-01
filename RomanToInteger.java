public class Solution {
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() functio
        if (s.length()==0) return 0;
        
        char[] ca=s.toCharArray();
        int res=0;
        int n=ca.length;
        res+=rctoi(ca[n-1]);
        for(int i=n-2;i>=0;i--){
            if (rctoi(ca[i])>=rctoi(ca[i+1])) res+=rctoi(ca[i]);
            else res-=rctoi(ca[i]);
        }
        return res;
    }
    
    private int rctoi(char rc){
        switch(rc){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:    assert false;
        }
        return -1;
    }
}
