// sliding window:
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;

        int[] map = new int[26];

        for(char c : p.toCharArray()) {
            map[c - 'a']++;
        }

        int l=0, r=0, count=p.length();
        while(r<s.length()) {
            int ri = s.charAt(r) - 'a';
            if(map[ri] > 0) count--;
            map[ri]--;
            r++;

            if(count==0) res.add(l);

            if(r-l == p.length()) {
                int li = s.charAt(l) - 'a';
                if (map[li]>=0) count++;
                map[li]++;
                l++;
            }
        }

        return res;
    }
}
