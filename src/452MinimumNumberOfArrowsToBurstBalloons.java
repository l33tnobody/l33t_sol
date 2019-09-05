// sort on ending and compare next starting and move limit to next ending...
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        // sort only on ending is enough:
        // Arrays.sort(points, (a,b) -> a[1] - b[1]);

        int limit = points[0][1];
        int count = 1;

        for(int i=1; i<points.length; i++) {
            if (points[i][0] <= limit) continue;

            count++;
            limit = points[i][1];
        }

        return count;
    }
}
