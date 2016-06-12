public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows<1)  return res;
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        arr0.add(1);
        res.add(arr0);
        for (int i=1; i<numRows; i++) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            List<Integer> prev = res.get(res.size()-1);
            for(int j=0; j<i+1; j++){
                arr.add((j > prev.size() - 1 ? 0 : prev.get(j)) +
                        (j-1 < 0 ? 0 : prev.get(j-1)));
            }
            res.add(arr);
        }
        return res;
    }
}
