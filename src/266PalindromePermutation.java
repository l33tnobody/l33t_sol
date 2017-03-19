public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int cCount = count.getOrDefault(c, 0);
            cCount++;
            count.put(c, cCount);
        }

        int odd = 0;
        for (int i : count.values()) {
            if (i%2 == 1) odd++;
        }

        return odd <= 1;
    }
}

// one pass
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }

        return set.size() <= 1;
    }
}
