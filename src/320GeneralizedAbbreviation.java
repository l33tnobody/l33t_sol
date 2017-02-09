public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder running = new StringBuilder();

        helper(res, word, 0, running, 0);

        return res;
    }

    // count is how many abbreviated so far
    private void helper(List<String> res, String word, int pos, StringBuilder running, int count) {
        int len = running.length();

        if (pos == word.length()) {
            if (count != 0) running.append(count);

            res.add(running.toString());
        } else {
            helper(res, word, pos + 1, running, count + 1);

            helper(res, word, pos + 1, count==0 ? running.append(word.charAt(pos)) : running.append(count).append(word.charAt(pos)), 0);
        }

        running.setLength(len);
    }
}

// using string:
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        // StringBuilder running = new StringBuilder();

        helper(res, word, 0, "", 0);

        return res;
    }

    // count is how many abbreviated so far
    private void helper(List<String> res, String word, int pos, String running, int count) {

        if (pos == word.length()) {
            if (count != 0) running += count;
            res.add(running);
            return;
        }

        helper(res, word, pos + 1, running, count + 1);

        helper(res, word, pos + 1, count==0 ? running + word.charAt(pos) : running + count
               + word.charAt(pos), 0);
    }
}
