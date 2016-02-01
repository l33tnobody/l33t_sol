public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res=new int[2];
        res[0]=res[1]=-1;
        int n=A.length;
        int l=0;
        int r=n-1;
        
        while(l<=r){
            int m=(l+r)/2;
            if(A[m]<target)
                l=m+1;
            else //A[m]>=target
                r=m-1;
        }
        if(l>=n||A[l]!=target) return res;
        res[0]=l;
        
        r=n-1;
        while(l<=r){
            int m=(l+r)/2;
            if(A[m]>target)
                r=m-1;
            else //A[m]<=target
                l=m+1;
        }
        res[1]=r;
        
        return res;
    }
}
