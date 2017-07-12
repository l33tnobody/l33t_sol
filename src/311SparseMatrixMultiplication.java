public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;

        int[][] res = new int[m][p];

        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(A[i][j] == 0) continue;

                for(int k=0; k<p; k++) {
                    if(B[j][k] == 0) continue;

                    res[i][k] += A[i][j] * B[j][k];
                }
            }
        }

        return res;
    }
}

// using one list to record the non zero element:
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];

        List[] indexA = new List[m];
        for(int i = 0; i < m; i++) {
            List<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(A[i][j] != 0){
                    numsA.add(j);
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        for(int i = 0; i < m; i++) {
            List<Integer> numsA = indexA[i];
            for(int p = 0; p < numsA.size() - 1; p += 2) {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for(int j = 0; j < nB; j ++) {
                    int valB = B[colA][j];
                    if (valB == 0) continue;

                    result[i][j] += valA * valB;
                }
            }
        }

        return result;
    }
}

// using two lists to record non-zero elements from both matrices.
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];

        List[] indexA = new List[m];
        for(int i = 0; i < m; i++) {
            List<Integer> numsA = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                if(A[i][j] != 0){
                    numsA.add(j);
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }

        List[] indexB = new List[n];
        for(int i=0; i<n; i++) {
            List<Integer> numsB = new ArrayList<>();
            for(int j=0; j<nB; j++) {
                if(B[i][j] != 0) {
                    numsB.add(j);
                    numsB.add(B[i][j]);
                }
            }
            indexB[i] = numsB;
        }

        for(int i = 0; i < m; i++) {
            List<Integer> numsA = indexA[i];
            for(int p = 0; p < numsA.size() - 1; p += 2) {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                List<Integer> numsB = indexB[colA];

                for(int j = 0; j < numsB.size() - 1; j+=2) {
                    int col = numsB.get(j);
                    int valB = numsB.get(j+1);
                    result[i][col] += valA * valB;
                }
            }
        }

        return result;
    }
}
