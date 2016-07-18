public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n==0) return 0;

        int [][] table = new int[2][n];

        List<Integer> last = triangle.get(n-1);
        for(int i=0; i<n; i++){
            table[(n-1)%2][i] = last.get(i);
        }

        for(int row=n-2; row>=0; row--){
            List<Integer> l = triangle.get(row);
            for (int i=0; i<l.size(); i++){
                table[row%2][i] = getMin(i, row, table) + l.get(i);
            }
        }

        return table[0][0];
    }

    private int getMin(int i, int row, int[][] table){
        int tr = (row + 1)%2;
        return Math.min(table[tr][i], table[tr][i+1]);
    }
}

// optimized: only one row of cache is needed, adjacent means current i and i+1
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n==0) return 0;

        Integer[] table = new Integer[n];
        triangle.get(n-1).toArray(table);

        for(int row=n-2; row>=0; row--){
            List<Integer> l = triangle.get(row);
            for (int i=0; i<l.size(); i++){
                table[i] = Math.min(table[i], table[i+1]) + l.get(i);
            }
        }

        return table[0];
    }
}
