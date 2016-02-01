public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        int r=0,w=0,b=n-1;
        
        for(;w<=b;) {
            if(A[w]==0) swap(A, r++, w++);
            else if(A[w]==2)    swap(A, b--, w);
            else w++;
        }
    }
    private void swap(int[] A, int i1, int i2){
        if(i1==i2)  return;
        int temp = A[i1];
        A[i1] = A[i2];
        A[i2] = temp;
    }
}
