class StringIterator {
    private int p;
    private String cs;
    private int total;
    private int curnum;
    private char c;

    public StringIterator(String compressedString) {
        cs = compressedString;
        p = 0;
        total = 0;
        curnum = 0;
        c = ' ';
    }

    public char next() {
        if (!hasNext()) return ' ';

        if (curnum == total) {
            c = cs.charAt(p++);
            total = getnum();
            curnum = 1;
            return c;
        }

        curnum++;
        return c;
    }

    public boolean hasNext() {
        return (p < cs.length() || curnum < total);
    }

    private int getnum() {
        int res = 0;
        while(p < cs.length() && Character.isDigit(cs.charAt(p))) { // or use Integer.parseInt(str.substring(i, j)
            int cn = Character.getNumericValue(cs.charAt(p));
            res = res*10 + cn;
            p++;
        }
        return res;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

// another solution from discussion: use two queues and parse all at the beginning.
// overhead if the data will not be fully used
public class StringIterator {
    List<Character> chars = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();
    int ptr = 0;

    public StringIterator(String str) {
        int i = 0;
        while (i < str.length()) {
            chars.add(str.charAt(i));
            int j = i + 1;
            while (j < str.length() && Character.isDigit(str.charAt(j))) j++;
            counts.add(Integer.parseInt(str.substring(i + 1, j)));
            i = j;
        }
    }

    public char next() {
        if (!hasNext()) return ' ';

        char result = chars.get(ptr);
        counts.set(ptr, counts.get(ptr) - 1);
        if (counts.get(ptr) == 0) ptr++;
        return result;
    }

    public boolean hasNext() {
        return ptr < chars.size();
    }
}
