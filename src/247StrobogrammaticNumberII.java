// best, fastest
public class Solution {

    private static final char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] running = new char[n];

        helper(res, running, 0, n - 1);

        return res;
    }

    private void helper(List<String> res, char[] running, int l, int r) {
        if (l>r) {
            res.add(new String(running));
            return;
        }

        for(char[] p : pairs) {
            if (l == 0 && l != r && p[0] == '0') continue;
            if (l == r && p[0] != p[1]) continue;

            running[l] = p[0];
            running[r] = p[1];
            helper(res, running, l + 1, r - 1);
        }
    }
}

// more space and string concat
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);

        List<String> res = new ArrayList<String>();

        for (String s : list) {

            if (n != m) res.add("0" + s + "0");

            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }

        return res;
    }
}

// first draft, not very concise
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        if (n % 2 == 1) {
            char[] center = {'0', '1', '8'};
            for (char c : center) {
                sb.append(c);
                helper(res, sb, n);
                sb.setLength(0);
            }
        } else {
            helper(res, sb, n);
        }

        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int n) {
        if (sb.length() >= n) {

            res.add(sb.toString());

        } else {
            char[] same = {'0', '1', '8'};

            for (char c : same) {
                if (sb.length() + 2 == n && c == '0') continue;

                sb.insert(0, c);
                sb.insert(sb.length(), c);
                helper(res, sb, n);
                removeEnd(sb);
            }

            sb.insert(0, '6');
            sb.insert(sb.length(), '9');
            helper(res, sb, n);
            removeEnd(sb);

            sb.insert(0, '9');
            sb.insert(sb.length(), '6');
            helper(res, sb, n);
            removeEnd(sb);
        }
    }

    private void removeEnd(StringBuilder sb) {
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
    }
}
