// additional space with one dimension internal list
public class Vector2D implements Iterator<Integer> {
    private List<Integer> l; // internal one dimension flattened list
    private int i; // current index

    public Vector2D(List<List<Integer>> vec2d) {
        i=0;
        l=new ArrayList<>();
        for(List<Integer> iter : vec2d) {
            for(Integer ii : iter) {
                l.add(ii);
            }
        }
    }

    @Override
    public Integer next() {
        Integer res = l.get(i);
        i++;
        return res;
    }

    @Override
    public boolean hasNext() {
        return i < l.size();
    }
}

// no additional space
public class Vector2D implements Iterator<Integer> {
    private int i; // i th element
    private int j; // j th list
    private List<List<Integer>> l;

    public Vector2D(List<List<Integer>> vec2d) {
        i=0;
        j=0;
        l = removeEmpty(vec2d);
    }

    private static List<List<Integer>> removeEmpty(List<List<Integer>> l){
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> iter : l) {
            if (iter.size() != 0) res.add(iter);
        }

        return res;
    }

    @Override
    public Integer next() {
        Integer res = l.get(j).get(i);

        // increment
        if (i < l.get(j).size()-1) {
            i++;
        } else {
            i=0;
            ++j;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        if (j >= l.size()) return false;

        return true;
    }
}

// using only iterator
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> m;
    private Iterator<Integer> n;
    List<List<Integer>> l;

    public Vector2D(List<List<Integer>> vec2d) {
        l = removeEmpty(vec2d);
        m = l.iterator();
        if (l.size() != 0) n = m.next().iterator();
    }

    private static List<List<Integer>> removeEmpty(List<List<Integer>> list){
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> iter : list) {
            if (iter.size() != 0) res.add(iter);
        }

        return res;
    }

    @Override
    public Integer next() {
        if (n.hasNext()) return n.next();

        n = m.next().iterator();
        return n.next();
    }

    @Override
    public boolean hasNext() {
        return m.hasNext() || (n != null && n.hasNext());
    }
}

// a better iterator version
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public Integer next() {
        hasNext();  // always try to push to next available list, optional
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
