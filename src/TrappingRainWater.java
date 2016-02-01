public class Solution {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A==null||A.length==0) return 0;
        
        int n=A.length;
        int water =0;
        int mid=0;
        for(int i=0;i<n;i++)    //get the peak of all
            if(A[i]>A[mid])
                mid=i;
        
        int h=0;    //highest height to the left
        for(int i=0;i<mid;i++){
            if(h>A[i])
                water+=h-A[i];
            else h=A[i];
        }
        
        h=0;    //highest height to the right
        for(int i=n-1;i>mid;i--){
            if(h>A[i])
                water+=h-A[i];
            else
                h=A[i];
        }
        
        return water;
    }
}
