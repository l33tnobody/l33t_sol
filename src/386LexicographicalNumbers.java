class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        helper(res, 0, n);
        return res;
    }
    
    private void helper(List<Integer> res, int pre, int n) {
        pre *= 10;
        for(int i = 0; i<=9; i++) {
            int newi = pre + i;
            if(newi == 0) continue;
            
            if(newi <= n) {
                res.add(newi);
                helper(res, newi, n);
            } else break;
        }
    }
}