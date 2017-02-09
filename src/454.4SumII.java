public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>(); // from sum to number of sum
        int res = 0;

        for(int m : A) {        //0 size arrays also apply
            for(int n : B) {
                int sum = m + n; // won't overflow
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int p : C) {
            for(int q : D) {
                int sum1 = p + q;
                res += map.getOrDefault(-sum1, 0);
            }
        }

        return res;
    }
}
