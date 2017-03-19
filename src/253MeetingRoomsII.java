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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval minEnd = heap.poll();

            if (intervals[i].start >= minEnd.end) {
                // if the current meeting starts after
                // there's no need for a new room, merge the interval with earliest end
                minEnd.end = intervals[i].end; // merge the intervals into one room
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            heap.offer(minEnd); // since minEnd.end may be updated, may need to reorder
        }

        // reorder minEnd only when its end gets updated.
        // for(int i=1; i<intervals.length; i++) {
        //     Interval minEnd = heap.peek();
        //
        //     if (intervals[i].start >= minEnd.end) {
        //         minEnd.end = intervals[i].end; // merge the intervals into one room
        //         heap.offer(heap.poll());
        //     } else {
        //         heap.offer(intervals[i]);
        //     }
        // }

        return heap.size();
    }
}
