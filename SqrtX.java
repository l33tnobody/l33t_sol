public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert x>=0;
        
        long l=0, r=(long)x;
        long mid;
        while(l<=r){
            mid=(l+r)/2;
            long t=mid*mid;
            if(t==x) return (int)mid;
            if(t<x) {l=mid+1; continue;}
            r=mid-1;
        }
        
        return (int)r;
    }
}
