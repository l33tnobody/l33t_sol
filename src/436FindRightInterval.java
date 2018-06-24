// binary search: nlogn
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        Map<Interval, Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) { // keep the original indexes
            hash.put(intervals[i], i);
        }
        
        Arrays.sort(intervals, (a, b) -> a.start - b.start); // sort based on start time
        for (int i = 0; i < intervals.length; i++) {
            Interval ceiling = bsearch(intervals, intervals[i].end);
            res[hash.get(intervals[i])] = ceiling == null ? -1 : hash.get(ceiling);
        }
        return res;
    }
    
    private Interval bsearch(Interval[] intervals, int end) { // find ceiling for end
        int lo = 0, hi = intervals.length;
        while(lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int start = intervals[mi].start;
            
            if(start < end) lo = mi + 1;
            else hi = mi; 
        }
        return hi == intervals.length ? null : intervals[hi];
    }
    /* another way to do binary search
    private Interval bsearch(Interval[] intervals, int end) { // find ceiling for end
        int lo = 0, hi = intervals.length - 1;
        while(lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int start = intervals[mi].start;
            
            if(start == end) return intervals[mi];
            if(start < end) lo = mi + 1;
            else hi = mi - 1; 
        }
        return lo == intervals.length ? null : intervals[lo];
    }
    */
}

// treemap:
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        int res[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i].end);
            res[i] = pos == null ? -1 : pos.getValue();
        }
        return res;
    }
}

// time: nlogn as well
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Map<Interval, Integer> origindex = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) { // keep the original indexes
            origindex.put(intervals[i], i);
        }
        int[] res = new int[intervals.length];
        
        Interval[] ends = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(ends, (a, b) -> a.end - b.end);
        Arrays.sort(intervals, (a, b) -> a.start - b.start); // sort based on start
        int j = 0;
        
        for(int i = 0; i < ends.length; i++) {
            while(j < intervals.length && intervals[j].start < ends[i].end) j++; // first start >= end 
            
            res[origindex.get(ends[i])] = j < intervals.length ? origindex.get(intervals[j]) : -1;
        }
        
        return res;
    }
}