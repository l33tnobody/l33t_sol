// compare: bottom up is easier
// optimized: only one row of cache is needed, adjacent means current i and i+1
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n==0) return 0;

        Integer[] table = new Integer[n]; // how many rows == how many columns in last row
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
