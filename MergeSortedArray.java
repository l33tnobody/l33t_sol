public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index=m+n-1;
        int ai=m-1, bi=n-1;
        while(bi!=-1){	//check if ai is empty as well!!!
            A[index--] = ai==-1? B[bi--] : (B[bi]>=A[ai]? B[bi--] : A[ai--]);
        }
    }
}
