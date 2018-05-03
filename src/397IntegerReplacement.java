
class Solution {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 0);
        map.put(2, 1);

        return helper(n, map);
    }

    private int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int steps = 0;
        if (n % 2 == 0) {
            steps = helper(n>>>1, map) + 1;
        } else {                                         // to recurse downward to the basecase and to address the possible overflow of (n+1) >>>1
            steps = Math.min(helper((n - 1) >>> 1, map), helper(1 + ((n - 1) >>> 1), map)) + 2;
        }

        map.put(n, steps);

        return steps;
    }
}


// another hardcore solution, based on observation: just for fun, not sure why correct
// https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations
public int integerReplacement(int n) {
    int c = 0;
    while (n != 1) {
        if ((n & 1) == 0) {
            n >>>= 1;
        } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
            --n;
        } else {
            ++n;
        }
        ++c;
    }
    return c;
}
