class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;

        int ps=0;
        for(int pt=0; pt<t.length(); pt++) {
            if(s.charAt(ps) == t.charAt(pt)) {
                ps++;
                if(ps == s.length()) return true;
            }
        }

        return false;
    }
}

// or can do preprocessing of t and some sort of binary search to reduce runtime for follow up
// https://leetcode.com/problems/is-subsequence/discuss/87268/Java-code-for-the-follow-up-question
class Solution {
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

        //preprocess t
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i); // will be sorted indexes
        }

        int prev = -1;  //index of previous character in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == null)  {
                return false;
            } else {
                List<Integer> list = map.get(c);
                prev = binarySearch(prev, list);
                if (prev == -1) return false;
            }
        }

        return true;
    }
    // find the proper index of the character in t that just greater the prev s char index in t
    private int binarySearch(int index, List<Integer> list) {
        int start = 0, end = list.size(); // n - 1 + 1

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) <= index) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end == list.size() ? -1 : list.get(end);
    }

}
