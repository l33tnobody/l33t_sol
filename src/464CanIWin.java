// O(n!) for not caching, 2^n for caching
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if ((1 + maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal) return false;
        return helper(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }

    private boolean helper(int total, int n, int state, Map<Integer, Boolean> map) {
        if (map.containsKey(state)) return map.get(state);

        for(int i=0, mask=1; i<n; i++, mask<<=1) {
            if((state & mask) != 0) continue; // used integer

            if(total<=i+1 || !helper(total-(i+1), n, state|mask, map) ) {
                map.put(state, true);
                return true;
            }
        }
        map.put(state, false);
        return false;
    }
}
