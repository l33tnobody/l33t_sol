/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (Interval i : intervals) {
            if (res.size() == 0 || res.get(res.size() - 1).end < i.start) res.add(i);

            // join i with the last one
            Interval last  = res.get(res.size() - 1);
            last.end = Math.max(last.end, i.end);
        }

        return res;
    }
}
