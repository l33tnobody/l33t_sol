// n^3 or m*n*n
// while naive approach only does n^6 brute force or n^4 DP

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        // turn into a presum matrix:
        for(int i=0; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }

        for(int l=0; l<matrix[0].length; l++) {
            for(int r=l; r<matrix[0].length; r++) {
                Map<Integer, Integer> m = new HashMap<>();
                m.put(0, 1);
                int sum = 0;

                for(int i=0; i<matrix.length; i++) {
                    int presum = matrix[i][r] - (l > 0 ? matrix[i][l-1] : 0);
                    sum += presum;
                    res += m.getOrDefault(sum-target, 0);
                    m.put(sum, m.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return res;
    }
}