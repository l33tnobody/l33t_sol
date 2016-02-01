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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        int n=intervals.size();
        Interval newInt=new Interval(newInterval.start, newInterval.end);
        ArrayList<Interval> res=new ArrayList<Interval>();
        
        for(;i<n && intervals.get(i).end<newInt.start; i++)
            res.add(intervals.get(i));
        //merge
        for(;i<n && newInt.end>=intervals.get(i).start;i++){
            newInt.start=Math.min(intervals.get(i).start, newInt.start);
            newInt.end=Math.max(intervals.get(i).end, newInt.end);
        }
        res.add(newInt);
        
        for(;i<n;i++)
            res.add(intervals.get(i));
            
        return res;
    }
}
