public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        for(int i=0;i<n;i++){
            if(A[i]>0&&A[i]<=n){
                int j=A[i]-1;   //intended index to put current A[i]
                if (j!=i&&A[j]!=A[i]){
                    swap(A,i,j);
                    i--;
                }
            }
        }

        for(int k=0;k<n;k++){
            if(k+1!=A[k])
                return k+1;
        }

        return n+1;
    }

    private void swap(int[] A, int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
