class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int s = 0, e = A[0].length - 1;
            while(s <= e) { // here need to take = as well, since the element needs to be inversed
                if(A[i][s] == A[i][e]) {  // if != flip and inverse the result is the same, so no need to anything
                    A[i][s] = A[i][e] = A[i][e] ^ 1;
                }
                s++;
                e--;
            }
        }
        return A;
    }
}