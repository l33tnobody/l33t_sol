

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int wlen = words[0].length();
        List<Integer> res = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<>();

        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(int i=0; i <= n-wlen*words.length; i++) {
            Map<String, Integer> need = new HashMap<String, Integer>(map);
            int count = words.length;

            for(int p=i; p < i+wlen*words.length ; p+=wlen) {
                String w = s.substring(p, p+wlen);
                if (!need.containsKey(w) || need.get(w) == 0) {
                    break;
                }
                need.put(w, need.get(w) - 1);
                count--;
            }
            if (count == 0) res.add(i);
        }

        return res;
    }
}
