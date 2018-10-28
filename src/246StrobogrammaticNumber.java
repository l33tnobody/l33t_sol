// using map
public class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] map = { '0', '1', 'n', 'n', 'n', 'n', '9', 'n', '8', '6' };

        int l = 0, r = num.length() - 1;
        while (l <= r) {
            int i = Character.getNumericValue(num.charAt(l));

            if (map[i] == 'n') return false;

            if (map[i] != num.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}

public class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        int l = 0, r = num.length() - 1;
        while (l <= r) {
            if (!map.containsKey(num.charAt(l))) return false;
            if (map.get(num.charAt(l)) != num.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }
}
