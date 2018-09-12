// construct 3N*3N matrix to expand A and check each possible translation against matrix B
// From the question: Note also that a translation does not include any kind of rotation.
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n=A.length, res=0;
        int[][] Ap= new int[3*n][3*n];
        for (int i=n; i<2*n; i++){
            for (int j=n; j<2*n; j++){
                Ap[i][j]=A[i-n][j-n];
            }
        }
        for (int i=0; i<=2*n; i++){
            for (int j=0; j<=2*n; j++){ // possible starting coordinate of B
                res=Math.max(res, helper(Ap, B, i, j));
            }
        }
        return res;
    }
    public int helper(int[][] A, int[][] B, int x, int y){
        int n=B.length, sum=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                sum+=B[i][j]*A[x+i][y+j];
            }
        }
        return sum;
    }
}

// brute force: check each translation when needed(both 1s in A and B), 
// faster and more space efficient than the previous solution
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N][2*N]; // possible diffs in row/col, ranging from -(n-1) to n-1: 2n-1 possible values
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }
}

// for sparse matrix: this will achieve better runtime:
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        
        // gather all 1s in both A and B in N*N time
        // note: 100 is big enough and easy to debug the flattened indexes, but ingeneral this base has to be 2N-1 to avoid collision with over possible coordinates (2N-1 due to 2N-1 possible diffs in rows and cols)
        for (int i = 0; i < N * N; ++i) if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
        for (int i = 0; i < N * N; ++i) if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        // if matrix is sparse in 1s, say m and n 1s in A and B, mn << N*N * N*N
        for (int i : LA) for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        
        int max = 0;
        for (int v : count.values()) max = Math.max(max, v);
        return max;
    }

}