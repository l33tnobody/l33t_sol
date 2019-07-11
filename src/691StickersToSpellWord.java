// too hard, don't read, just for fun
// 56 ms
// all strings sorted in int[26] array and
// optimize search by trying to match the first char of target first, see line 24
// also the cache is based on sorted strings as key (i.e. "aab", "aba" has the same number of min number of stickers)
class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length;
        int[][] mp = new int[m][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (char c : stickers[i].toCharArray()) mp[i][c-'a']++;
        dp.put("", 0);
        return helper(dp, mp, target); // can check if target has char which non of the stickers has, if so return -1. (might be faster)
    }

    private int helper(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int ans = Integer.MAX_VALUE, n = mp.length;
        int[] tar = new int[26];
        for (char c : target.toCharArray()) tar[c - 'a']++;
        // try every sticker
        for (int i = 0; i < n; i++) {
            // optimization
            if (mp[i][target.charAt(0)-'a'] == 0) continue; // one of the sticker has to match the first char in target
            StringBuilder sb = new StringBuilder();
            // apply a sticker on every character a-z
            for (int j = 0; j < 26; j++) { // the cache key is sorted
                if (tar[j] > 0 )
                    for (int k = 0; k < Math.max(0, tar[j]-mp[i][j]); k++)
                        sb.append((char)('a'+j));
            }
            String s = sb.toString();
            int tmp = helper(dp, mp, s);
            if (tmp != -1) ans = Math.min(ans, 1+tmp);
        }

        ans = (ans == Integer.MAX_VALUE) ? -1 : ans;
        dp.put(target, ans);
        return ans;
    }
}


// is there a iterative DP? you bet. using bit map to indicate matching status, just for fun dont read not as good as above^^^
// 118 ms since there are duplicate equal state, strings can be consolidated and sorted.
class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length(), m = 1 << n; // if target has n chars, there will be m=2^n-1 subset of characters in target
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) dp[i] = Integer.MAX_VALUE; // use index 0 - 2^n-1 as bitmaps to represent each subset of all chars in target
        dp[0] = 0; // first thing we know is : dp[empty set] requires 0 stickers,
        for (int i = 0; i < m; i++) { // for every subset i, start from 000...000
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) { // try use each sticker as an char provider to populate 1 of its superset, to do that:
                int sup = i;
                for (char c : s.toCharArray()) { // for each char in the sticker, try apply it on a missing char in the subset of target
                    for (int r = 0; r < n; r++) {
                        if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
               // after you apply all possible chars in a sticker, you get an superset that take 1 extra sticker than subset
               // would take, so you can try to update the superset's minsticker number with dp[sub]+1;
                dp[sup] = Math.min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m - 1] == Integer.MAX_VALUE ? -1 : dp[m - 1];
    }
}
