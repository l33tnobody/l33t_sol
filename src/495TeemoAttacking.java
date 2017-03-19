public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;

        int res = 0;
        for (int i=0; i < timeSeries.length - 1; i++) {
            int t = timeSeries[i+1] - timeSeries[i];
            res += (t < duration) ? t : duration;
        }
        res += duration;
        return res;
    }
}
