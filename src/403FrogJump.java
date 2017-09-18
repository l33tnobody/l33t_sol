// DFS better?
class Solution {
    Map<Integer, Boolean> map = new HashMap<>(); // cache keyed on pos and k (step)

    public boolean canCross(int[] stones) {
        return helper(stones, 0, 0); // initially on the first stone and can do at most 1 jump (0 stay, -1 invalid, and also stones are monotonic increasing)
    }

    private boolean helper(int[] stones, int pos, int k) {
        if (pos == stones.length-1) return true;

        int key = (k << 11) | pos;  //pos < 1100, move k to 2048 based 2^11
        if(map.containsKey(key)) return map.get(key);

        for(int i=pos+1; i<stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if(gap < k-1) continue;
            if(gap > k+1) {
                map.put(key, false);
                return false;
            }

            if(helper(stones, i, gap)) return true; // no need to cache true, will return all true in a chain on the first true.
        }

        map.put(key, false);
        return false;
    }
}


// DP solution: https://discuss.leetcode.com/topic/59903/very-easy-to-understand-java-solution-with-explanations
public boolean canCross(int[] stones) {
    Map<Integer, HashSet<Integer>> map = new HashMap<>(stones.length);
    map.put(0, new HashSet<Integer>());
    map.get(0).add(1);
    for (int i = 1; i < stones.length; i++) {
    	map.put(stones[i], new HashSet<Integer>() ); // a set to record all the steps
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
