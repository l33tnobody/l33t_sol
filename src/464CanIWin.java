// DFS caching with a bit map representing used number states:
// O(n!) for not caching, 2^n for caching (2^n states)
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) return false;
        return helper(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }

    private boolean helper(int total, int n, int state, Map<Integer, Boolean> map) {
        if (map.containsKey(state)) return map.get(state); // state is based on used integers which also corresponds to the same total left

        for(int i=0, mask=1; i<n; i++, mask<<=1) { // for(int i=n, mask=1; i>=1; i--, mask<<=1) might be faster
            if((state & mask) != 0) continue; // used integer, bitwise AND

            if(total<=i+1 || !helper(total-(i+1), n, state|mask, map) ) { // bitwise OR
                map.put(state, true);
                return true;
            }
        }
        map.put(state, false);
        return false;
    }
}
