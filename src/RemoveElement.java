public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        int cur=0;
        for (int i=0;i<A.length;i++){
            if(A[i]!=elem)  {
                A[cur]=A[i];
                cur++;
            }
        }
        return cur;
    }
}
