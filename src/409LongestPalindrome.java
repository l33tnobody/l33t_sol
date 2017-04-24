public class Solution {
    public int longestPalindrome(String s) {
        int odd=0;
        int totaleven=0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        for(char c : map.keySet()) {
            int n = map.get(c);
            if (n%2 == 0) {
                totaleven += n;
                continue;
            }
            totaleven += n-1;
            odd = 1;
        }

        return totaleven + odd;
    }
}

public class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int pairs = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                pairs++;
            } else {
                set.add(c);
            }
        }

        return set.isEmpty() ? pairs*2 : pairs*2+1;
    }
}
