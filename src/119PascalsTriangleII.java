public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if (rowIndex<0)
            return res;
        for (int i=0; i<=rowIndex; i++) {
            res.add(0, 1);
            for (int j=1; j<i; j++) { // starting from index 1 to the second to last index
                res.set(j, res.get(j)+res.get(j+1));
            }
        }
        return res;
    }
}
