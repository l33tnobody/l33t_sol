// Using Word-BreakI algo:
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}

// Trie based:
public class Solution {
//    private Set<String> cache = new HashSet<>(); // using cache to remember previously known breakable words

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = new TrieNode();

        for (String word : words) { // constrstruct Trie tree
            addWord(word, root);
        }
        for (String word : words) { // test word is a concatenated word or not
            if (testWord(word, 0, root, 0)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean testWord(String word, int index, TrieNode root, int count) {
//        if (cache.contains(word.substring(index))) return true;

        TrieNode cur = root;
        int n = word.length();

        for (int i = index; i < n; i++) {
            cur = cur.children[word.charAt(i) - 'a'];

            if (cur == null) return false;

            if (cur.isEnd) {
                if (i == n-1 && count + 1 > 1) return true;

                if (testWord(word, i + 1, root, count + 1)) { // try break word here
//                    cache.add(word.substring(index));
                    return true;
                }
            }
        }

        return false;
    }

    public void addWord(String word, TrieNode root) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }
}
