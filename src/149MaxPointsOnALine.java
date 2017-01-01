/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result=0;
        for(int i=0; i<points.length; i++) {
            map.clear();
            int max=0, overlap=0;
            for(int j=i+1; j<points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;

                if (x==0&&y==0) {
                    overlap++;
                    continue;
                }

                int gcd = genGCD(x, y);
                x/=gcd;
                y/=gcd;

                if (map.containsKey(x)) {
                    Map<Integer, Integer> m = map.get(x);
                    if (m.containsKey(y)) {
                        m.put(y, m.get(y) + 1);
                    } else {
                        m.put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }

                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max+overlap+1);
        }
        return result;
    }

    public int genGCD(int x, int y) {
        if (y==0) return x;
        return genGCD(y, x%y);
    }
}
