public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        if(n<=1) return n;
        
        int i=0;
        for (int j=1;j<n;j++){
            if(A[i]!=A[j]){
                A[++i]=A[j];
            }
        }
        
        return i+1;
    }
}
