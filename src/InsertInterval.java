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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        int n = intervals.size();
        Interval newint = new Interval(newInterval.start, newInterval.end); // don't change the input
        int i=0;

        while(i<n && intervals.get(i).end < newint.start){
            res.add(intervals.get(i));
            i++;
        }

        while(i<n && intervals.get(i).start <= newint.end) {
            newint.start = Math.min(newint.start, intervals.get(i).start);
            newint.end = Math.max(newint.end, intervals.get(i).end);
            i++;
        }
        res.add(newint);

        while(i<n) {
            res.add(intervals.get(i));
            i++;
        }

        return res;
    }
}
