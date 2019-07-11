// For fun:
// Set and kadane n^3logn; if m is min(row, col) and n is max(row, col):
// runtime: m^2*n*logn
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for(int c1=0; c1<col; c1++) {
            int[] sums = new int[row];
            for(int c2=c1; c2<col; c2++) {
                for(int r=0; r<row; r++) {
                    sums[r] += matrix[r][c2];
                }

                TreeSet<Integer> set = new TreeSet<>();
                int cum=0; //cumulative sum
                set.add(cum);
                for(int s : sums) {
                    cum += s;
                    Integer ceiling = set.ceiling(cum-k); // logn time
                    if (ceiling != null)
                        max = Math.max(max, cum-ceiling);
                    set.add(cum);
                }
            }
        }
        // most inner loop can be combined
        // for(int c1=0; c1<col; c1++) {
        //     int[] sums = new int[row];
        //     for(int c2=c1; c2<col; c2++) {
        //         TreeSet<Integer> set = new TreeSet<>();
        //         int cum=0; //cumulative sum
        //         set.add(cum);
        //
        //         for(int r=0; r<row; r++) {
        //             sums[r] += matrix[r][c2];
        //             cum += sums[r];
        //             Integer ceiling = set.ceiling(cum-k);
        //             if (ceiling != null)
        //                 max = Math.max(max, cum-ceiling);
        //             set.add(cum);
        //         }
        //     }
        // }

        return max;
    }
}

// O(n^4)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] areas = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int area = matrix[r][c];
                if (r-1 >= 0)
                    area += areas[r-1][c];
                if (c-1 >= 0)
                    area += areas[r][c-1];
                if (r-1 >= 0 && c-1 >= 0)
                    area -= areas[r-1][c-1];
                areas[r][c] = area;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        int area = areas[r2][c2];
                        if (r1-1 >= 0)
                            area -= areas[r1-1][c2];
                        if (c1-1 >= 0)
                            area -= areas[r2][c1-1];
                        if (r1-1 >= 0 && c1 -1 >= 0)
                            area += areas[r1-1][c1-1];
                        if (area <= k)
                            max = Math.max(max, area);
                    }
                }
            }
        }
        // using set and ceiling to optimize (Kadane Algorithm)
        // O(n^3logn)
        // for (int r1 = 0; r1 < rows; r1++) {
        //     for (int r2 = r1; r2 < rows; r2++) {
        //         TreeSet<Integer> tree = new TreeSet<>();
        //         tree.add(0);    // padding
        //         for (int c = 0; c < cols; c++) {
        //             int area = areas[r2][c];
        //             if (r1-1 >= 0)
        //                 area -= areas[r1-1][c];
        //             Integer ceiling = tree.ceiling(area - k);
        //             if (ceiling != null)
        //                 max = Math.max(max, area - ceiling);
        //             tree.add(area);
        //         }
        //     }
        // }
        return max;
    }
}
