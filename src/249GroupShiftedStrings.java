public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(); // normalized string as key to groups of strings

        for (String s : strings) {
            String key = norm(s);
            List<String> l = map.getOrDefault(key, new ArrayList<String>());
            l.add(s);
            map.put(key, l);
        }

        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    private String norm(String w) {
        String res = "";
        int offset = w.charAt(0) - 'a';

        for (int i = 0; i < w.length(); i++) {
            char shifted = (char) (w.charAt(i) - offset);
            if (shifted < 'a') {
                shifted += 26;
            }
            res += shifted;
        }
        return res;
    }
}
