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
        int res = Integer.MAX_VALUE;

        for(List<Integer> s : special) {
            List<Integer> needsCopy = new ArrayList<>(needs);
            boolean valid = true;
            for(int i=0; i<needs.size(); i++) {
                int remain = needs.get(i) - s.get(i);
                if(remain < 0) {
                    valid = false;
                    break;
                }
                needsCopy.set(i, remain);
            }
            if(valid) res = Math.min(res, s.get(needs.size()) + dfs(price, special, needsCopy, dp));
        }

        // in case no valid special can be used, or specials do not save money:
        int noSpecial = 0;
        for(int i=0; i<needs.size(); i++) {
            noSpecial += needs.get(i) * price.get(i);
        }
        res = Math.min(res, noSpecial);
        dp.put(needs, res);
        return res;
    }
}
