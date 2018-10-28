public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>(); // distance to number of pairs

        for(int i=0; i<points.length; i++) { // for every mid point
            for(int j=0; j<points.length; j++) { // distance to all other points
                if (j==i) continue;

                int d = getDist(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for(int val : map.values()) {
                result += val * (val-1);
            }

            map.clear();
        }

        return result;
    }

    private int getDist(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];

        return dx*dx + dy*dy;
    }
}
