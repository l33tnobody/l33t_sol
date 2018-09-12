// most straightforward and efficient algo:
// Time O(nlen) space O(nlen), where len is the length of an average word
public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<Integer>> abbrMap = new HashMap<>(); // from the same abbrv to indexes
        // 1) create result set
        List<String> res = new ArrayList<>(Collections.nCopies(dict.size(), null)); // just put size in param
        // 2) Group all words with the same shortest abbreviation. For example:
        // "internal", "interval" => grouped by "i6l"
        // "intension", "intrusion" => grouped by "i7n"
        // "god" => grouped by "god"
        // we can notice that only words with the same length and the same start
        // and end letter could be grouped together
        for (int i = 0; i < dict.size(); i ++) {
            String word = dict.get(i);
            String st = getShortestAbbr(word);
            List<Integer> pos = abbrMap.get(st);
            if (pos == null) {
                pos = new ArrayList<>();
                abbrMap.put(st, pos);
            }
            pos.add(i);
        }
        // 3) Resolve conflicts in each group
        for (Map.Entry<String, List<Integer>> entry : abbrMap.entrySet()) {
            String abbr = entry.getKey();
            List<Integer> pos = entry.getValue();
            resolve(dict, res, abbr, pos);
        }
        return res;
    }
    
    /**
     * To resolve conflicts in a group, we could build a trie for all the words
     * in the group. The trie node will contain the count of words that has the
     * same prefix. Then we could use this trie to determine when we could resolve
     * a conflict by identifying that the count of words in that trie node will only
     * have one word has the prefix.
     */
    private void resolve(List<String> dict, List<String> res, String abbr, List<Integer> pos) {
        if (pos.size() == 1) {
            res.set(pos.get(0), abbr);
        } else {
            Trie trie = buildTrie(dict, pos);
            for (int p : pos) {
                String w = dict.get(p);
                Trie cur = trie;
                int i = 0;
                int n = w.length();
                // while loop to find the trie node which only has the 1 word which has
                // the prefix. That means in that position, only current word has that
                // specific character.
                while (i < n && cur.next.get(w.charAt(i)).cnt > 1) {
                    cur = cur.next.get(w.charAt(i));
                    i ++;
                }
                if (i >= n - 3) {
                    res.set(p, w);
                } else {
                    String pre = w.substring(0, i+1);
                    String st = pre + (n - i - 2) + "" + w.charAt(n - 1);
                    res.set(p, st);
                }
            }
        }
    }
    
    /**
     * Get the shortest abbreviation for a word
     */ 
    private String getShortestAbbr(String s) { // can general this function to get abbreviate starting at ith char
        if (s.length() <= 3) {
            return s;
        } else {
            return s.charAt(0) + "" + (s.length() - 2) + "" + s.charAt(s.length() - 1);
        }
    }
    
    /**
     * Standard way to build the trie, but we record each trie node with the information
     * of the count of words with the same prefix.
     */
    private Trie buildTrie(List<String> dict, List<Integer> pos) {
        Trie root = new Trie();
        for (int p : pos) {
            String w = dict.get(p);
            Trie cur = root;
            for (int i = 0; i < w.length(); i ++) {
                char c = w.charAt(i);
                if (cur.next.containsKey(c)) {
                    cur = cur.next.get(c);
                } else {
                    Trie next = new Trie();
                    cur.next.put(c, next);
                    cur = next;
                }
                cur.cnt ++;
            }
        }
        return root;
    }
    
    private class Trie {
        int cnt = 0;
        Map<Character, Trie> next = new HashMap<>(); // can use Trie[26] based on chars
    }
}