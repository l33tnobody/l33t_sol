class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return intervals;

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] > last[1]) {
                res.add(cur);
                continue;
            }

            // join i with the last one
            last[1] = Math.max(last[1], cur[1]);
        }

        int[][] resarr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resarr[i] = res.get(i);
        }

        return resarr;
    }
}