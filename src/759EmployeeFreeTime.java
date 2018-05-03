/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> timeline = new ArrayList<>();
        for(List<Interval> l : schedule) timeline.addAll(l);
        Collections.sort(timeline, ((a,b) -> a.start - b.start));

        Interval ii = timeline.get(0);
        for(Interval i : timeline) {
            if(ii.end < i.start) {
                res.add(new Interval(ii.end, i.start));
                ii = i;
            } else { // no gap
                ii = (ii.end < i.end) ? i : ii;
            }
        }

        return res;
    }
}
