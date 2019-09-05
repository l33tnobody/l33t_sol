/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// nlogn
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

// nlog(number of employees)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> ans = new ArrayList();
        PriorityQueue<Job> pq = new PriorityQueue<Job>(
                (a, b) -> avails.get(a.eid).get(a.index).start - avails.get(b.eid).get(b.index).start);
        int ei = 0, anchor = Integer.MAX_VALUE;

        for (List<Interval> employee : avails) {
            pq.offer(new Job(ei++, 0));
            anchor = Math.min(anchor, employee.get(0).start);
        }

        while (!pq.isEmpty()) {
            Job job = pq.poll();
            Interval iv = avails.get(job.eid).get(job.index);
            if (anchor < iv.start)
                ans.add(new Interval(anchor, iv.start));
            anchor = Math.max(anchor, iv.end);
            if (++job.index < avails.get(job.eid).size())
                pq.offer(job);
        }

        return ans;
    }
}

class Job {
    int eid, index;

    Job(int e, int i) {
        eid = e;
        index = i;
    }
}