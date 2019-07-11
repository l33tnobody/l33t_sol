// Time O(n^2) since numebr of overlaps are bound by the number of intervals (cannot be more than 3 overlapping),
// Space O(n^2) (overlaps can be O(n^2))
class MyCalendarTwo {
    List<int[]> calendar;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        calendar = new ArrayList();
        overlaps = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv : overlaps) {
            if (Math.max(iv[0], start) < Math.min(iv[1], end))
                return false;
        }

        for (int[] iv : calendar) {
            if (Math.max(iv[0], start) < Math.min(iv[1], end))
                overlaps.add(new int[] { Math.max(start, iv[0]), Math.min(end, iv[1]) });
        }
        calendar.add(new int[] { start, end });
        return true;
    }
}

// Boundary Count:
// make use of ordered map, values() will be iterate over according to keys order (time)
// n^2 time and n space
class MyCalendarTwo {
    TreeMap<Integer, Integer> delta; // time, number of events

    public MyCalendarTwo() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d : delta.values()) { // values will be ordered by key
            active += d;
            if (active >= 3) {
                // recover
                delta.put(start, delta.get(start) - 1);
                if (delta.get(start) == 0) // reduce number of keys save time and space
                    delta.remove(start);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(end) == 0)
                    delta.remove(end);
                return false;
            }
        }

        return true;
    }
}