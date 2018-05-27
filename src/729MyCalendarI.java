// a brute force, linear way:
class MyCalendar {

    List<int[]> books;

    public MyCalendar() {
        books = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] b : books) {
            if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
        }
        books.add(new int[]{ start, end });
        return true;
    }
}

// can do binary search and insert at the found index, comparator will consider coliding as equal
class MyCalendar {

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
