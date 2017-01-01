public class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();

        for(int[] p : points) {
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0] + "&" + p[1]);
        }

        int sum = max + min; // works also for single/same point

        for(int p[] : points) {
            int anotherx = sum - p[0];
            if (!set.contains(anotherx + "&" + p[1])) {
                return false;
            }
        }

        return true;
    }
}
