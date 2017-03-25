public class Solution {
    Map<Character, Integer> count = new HashMap<>();
    char oddChar = ' ';

    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() <= 1) {
            res.add(s);
            return res;
        }

        if (!canPermutePalindrome(s)) return res;

        constructPP(res, s.length());

        return res;
    }

    private boolean canPermutePalindrome(String s) {
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int cCount = count.getOrDefault(c, 0);
            cCount++;
            count.put(c, cCount);
        }

        int numOdd = 0;
        for (char c : count.keySet()) {
            if (count.get(c) % 2 == 1) {
                numOdd++;
                oddChar = c;
            }
        }

        return numOdd <= 1;
    }

    private void constructPP(List<String> res, int len) {
        char[] ca = new char[len];

        int index = 0;
        for(char c : count.keySet()) {
            for(int i=0; i<count.get(c)/2; i++) {
                ca[index++] = c;
            }
        }

        pputil(res, ca, 0);
    }

    private void pputil(List<String> res, char[] ca, int s) {
        if (s == ca.length/2 - 1) {
            fillRest(ca);
            res.add(new String(ca));
            return;
        }

        Set<Character> set = new HashSet<>();     // remove duplicate
        for(int i=s; i<ca.length/2; i++) {
            if (set.contains(ca[i])) continue;
            set.add(ca[i]);
            swap(ca, s, i);
            pputil(res, ca, s+1);
            swap(ca, s, i);
        }
    }

    private void swap(char[] ca, int i, int j) {
        if(i==j) return;

        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }

    private void fillRest(char[] ca) {
        if (oddChar != ' ') ca[ca.length/2] = oddChar;

        for (int i=0; i<ca.length/2; i++) {
            ca[ca.length - 1 - i] = ca[i];
        }
    }
}
