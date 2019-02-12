// DP solution: https://discuss.leetcode.com/topic/59903/very-easy-to-understand-java-solution-with-explanations
public boolean canCross(int[] stones) {
    // from stone id to its possible steps, use hashset to dedup duplicated steps
    Map<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
    map.put(0, new HashSet<>());
    map.get(0).add(1);
    for (int i = 1; i < stones.length; i++) {
    	map.put(stones[i], new HashSet<>()); // a set to record all the steps
    }

    for (int i = 0; i < stones.length - 1; i++) {
        int stone = stones[i];
        for (int step : map.get(stone)) {
            int reach = step + stone;
            if (reach == stones[stones.length - 1]) {
                return true;
            }
            HashSet<Integer> set = map.get(reach);
            if (set != null) {
                set.add(step);
                if (step - 1 > 0) set.add(step - 1);
                set.add(step + 1);
    		}
    	}
    }

    return false;
}
