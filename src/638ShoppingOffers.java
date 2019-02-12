// recursive dp with cache easier than doing the bottom up approach with arrays
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> dp = new HashMap<>();
        return dfs(price, special, needs, dp);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        int sum = 0;
        for(int n : needs) sum += n;
        if(sum == 0) return 0;

        if(dp.containsKey(needs)) return dp.get(needs);

        int res = 0;
        // in case no valid special can be used, or specials do not save money:
        // bottomline:
        for(int i=0; i<needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }

        for(List<Integer> s : special) {
            List<Integer> needsCopy = new ArrayList<>(needs);
            int i = 0;
            for(; i<needs.size(); i++) {
                int remain = needs.get(i) - s.get(i);
                if(remain < 0) {
                    break;
                }
                needsCopy.set(i, remain);
            }
            if(i == needs.size()) res = Math.min(res, s.get(needs.size()) + dfs(price, special, needsCopy, dp));
        }

        dp.put(needs, res);
        return res;
    }
}
