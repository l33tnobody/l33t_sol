// 223 ms
public class Solution {
    public boolean canWin(String s) {
        for(int i=0; i<s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String derived = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(derived)) return true;
            }
        }
        return false;
    }
}

// with cache 40 ms
public class Solution {
    private Map<String, Boolean> map = new HashMap<>();

    public boolean canWin(String s) {
        if (map.containsKey(s)) return map.get(s);

        for(int i=0; i<s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String derived = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(derived)) return true;
            }
        }

        map.put(s, false);
        return false;
    }
}
