// straightforward O(n^2)
class Solution {
    private class Interval {
        int start, end, height;
        public Interval(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Interval> intervals = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int maxheight = 0;
        for (int[] pos : positions) {
            Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
            int newh = getHeight(intervals, cur);
            maxheight = Math.max(maxheight, newh);
            res.add(maxheight);
        }
        return res;
    }

    private int getHeight(List<Interval> intervals, Interval cur) {
        int preMaxHeight = 0;
        for (Interval i : intervals) {
            // Interval i does not intersect with cur
            if (i.end < cur.start || i.start > cur.end) continue;
            // find the max height beneath cur
            preMaxHeight = Math.max(preMaxHeight, i.height);
        }
        cur.height += preMaxHeight;
        intervals.add(cur);
        return cur.height;
    }
}


// segment tree is a great fit for this question:
// optimization technics for segment tree:
// coordinates compression: lower space used and speedup query updates
// lazy propagation on updates for speeding up range updates
// https://leetcode.com/problems/falling-squares/discuss/112678/Treemap-solution-and-Segment-tree-(Java)-solution-with-lazy-propagation-and-coordinates-compression
// nlogn time, n space
int h = tree.query(L, R) + pos[1];tree.update(L,R,h);best=Math.max(best,h);





// not very straightforward Treemap solution: nlogn assuming k overlapping average
class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // at first, there is only one segment starting from 0 with height 0
        map.put(0, 0);

        // The global max height is 0
        int max = 0;

        for(int[] position : positions) {

            // the new segment
            int start = position[0], end = start + position[1];

            // find the height among this range
            Integer key = map.floorKey(start);
            int h = map.get(key);
            key = map.higherKey(key);
            while(key != null && key < end) {
                h = Math.max(h, map.get(key));
                key = map.higherKey(key);
            }
            h += position[1];

            // update global max height
            max = Math.max(max, h);
            list.add(max);

            // update new segment and delete previous segments among the range
            int tail = map.floorEntry(end).getValue();
            map.put(start, h);
            map.put(end, tail);
            key = map.higherKey(start);
            while(key != null && key < end) {
                map.remove(key);
                key = map.higherKey(key);
            }
        }
        return list;
    }
}

