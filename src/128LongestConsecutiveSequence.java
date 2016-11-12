public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if (!map.containsKey(n)){
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;

                int len  = left + right + 1;
                map.put(n, len); // n might be a boundry

                res = Math.max(res, len);

                // update new boundries
                map.put(n-left, len); // might be n itself
                map.put(n+right, len); // might be n itself
            } else {
                continue;
            }
        }
        return res;
    }
}
