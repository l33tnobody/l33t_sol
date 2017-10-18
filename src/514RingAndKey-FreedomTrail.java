class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<String, Integer> map = new HashMap();
        return dfs(ring, key, 0, map);
    }

    public int dfs(String ring, String key, int index, Map<String, Integer> map) {
        if(index == key.length()){
            return 0;
        }

        String hashKey = ring + index;
        if(map.containsKey(hashKey)) return map.get(hashKey);

        char c = key.charAt(index);
        int minSteps = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == c) {
                String s = ring.substring(i, ring.length()) + ring.substring(0, i);
                int steps = 1 + Math.min(i, ring.length() - i);
                steps += dfs(s, key, index + 1, map);
                minSteps = Math.min(minSteps, steps);
            }
        }

        map.put(hashKey, minSteps);
        return minSteps;
    }
}


// for reference only: a dp solution hard to think of:
// j represents the index of the ring character, that is currently at 12 o clock. dp[i][j] represents the minimum cost (number of rotations without pressing button), for spelling a whole subkey starting at i-th character, when j-th character of the ring is at 12 o clock. The whole for(k=0; k<n;k++) loop represents a search for i-th character of key in the ring string. The diff and n - diff represents costs for rotating k-th character found in ring to 12 o clock. One is clockwise and another is // counterclockwise.
//step is the minimum cost between clockwise and counterclockwise rotation. Diff and step do not include cost for pressing the center button, because this cost for the whole key will be always equal to number of characters in the key. So at the end the code returns dp[0][0] + m. dp[0][0] means cost (without pressing center button) for spelling the key starting at 0-th character when 0-th character of ring is at 12 o' clock. m represents cost of pressing center button for // every character in key in this context.
// The dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]) represents the recursive relation for the problem and subproblem. Minimum cost for spelling the key starting at i-th character when j-th ring character is at 12 o' clock (dp[i][j]) is equal to the minimal number of steps required to rotate the k-th character of ring to 12 o'clock (step) + the minimum cost for spelling the key starting at i-th + 1 character when k-th character is already at 12 o'clock (dp[i+1][k]).

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n]; // m+1 indexes, index m is empty key so all 0

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }
}
