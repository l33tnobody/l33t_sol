public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        int l=0,r=n-1;
        
        while(l<=r){
            int m=(l+r)/2;
            if(A[m]==target) return m;
            if(A[m]>target) r=m-1;
            else l=m+1;
        }
        return l;
    }
}
