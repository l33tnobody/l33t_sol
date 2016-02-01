public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=(l+r)/2;
            if(A[m]==target) return true;
            
            if(A[l]<A[m]){
                if(target>=A[l]&&target<A[m]){
                    r=m-1;
                    continue;
                }else{
                    l=m+1;
                    continue;
                }
            }else if(A[l]>A[m]){  //right half is sorted
                if(target>A[m]&&target<=A[r]){
                    l=m+1;
                    continue;
                }else{
                    r=m-1;
                    continue;
                }
            }else   //A[l]==A[m] get rid of A[l], O(n) worst case
                l++;
        }
        return false;

    }
}
