class MyCalendarTwo {
    // cannot use two treemaps because: for one new booking,
    // we will have to find all its overlapping with the existing bookings and
    // see if the new overlaps have overlaps with each other,
    // and treemap can only find one such overlap
    List<int[]> bookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        MyCalendar overlaps = new MyCalendar(); // note this one needs to be recreated everytime for a new booking, to check common overlaps of three

        for(int[] b : bookings) {
            if(Math.max(b[0], start) < Math.min(b[1], end)) { // find overlapping
                if (!overlaps.book(Math.max(b[0], start), Math.min(b[1], end))) return false;
            }
        }
        bookings.add(new int[]{ start, end });
        return true;
    }

    class MyCalendar { // for all the overlaps
        TreeMap<Integer, Integer> tm; // start, end

        public MyCalendar() {
            tm = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer low = tm.lowerKey(end); // strictly less than
            if(low != null && tm.get(low) > start) return false;

            tm.put(start, end);
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
