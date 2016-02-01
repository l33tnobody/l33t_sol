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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty())   return res;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) return -1;
                if (i1.start > i2.start) return 1;                
                //i1.start==i2.start
                return 0;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        for (Interval cur : intervals) {
            if(res.isEmpty()) {res.add(cur);continue;}
            
            Interval last=res.get(res.size() - 1);
            if(last.end>=cur.start) last.end=Math.max(last.end, cur.end);
            else res.add(cur);
        }
        
        return res;
        
    }
}
