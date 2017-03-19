public class ZigzagIterator {
    List<Iterator<Integer>> l;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l = new LinkedList<>();
        if (!v1.isEmpty()) l.add(v1.iterator());
        if (!v2.isEmpty()) l.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> i = l.remove(0);
        int res = i.next();
        if (i.hasNext()) l.add(i);
        return res;
    }

    public boolean hasNext() {
        return !l.isEmpty();
    }
}

public class ZigzagIterator {
    private List<List<Integer>> l;
    private int i, j;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l = new LinkedList<List<Integer>>();
        if (!v1.isEmpty()) l.add(v1);
        if (!v2.isEmpty()) l.add(v2);
        i = j = 0;
    }

    public int next() {
        int res = l.get(i).get(j);
        if (j == l.get(i).size() - 1) {
            l.remove(i);
            i--;
        }

        if (i == l.size() - 1) {
            i=0;
            j++;
        } else {
            i++;
        }

        return res;
    }

    public boolean hasNext() {
        return !l.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
