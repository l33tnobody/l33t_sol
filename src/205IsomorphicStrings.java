// using position to mark mappings: recommended
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for(int i=0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(m1[cs] != m2[ct]) return false;
            m1[cs] = i + 1;
            m2[ct] = i + 1;
        }

        return true;
    }
}

// using map
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if (!mapS.containsKey(cs) && !mapT.containsKey(ct)) {
                mapS.put(cs, ct);
                mapT.put(ct, cs);
                continue;
            }

            if (mapS.containsKey(cs) && mapT.containsKey(ct)) {
                if (mapS.get(cs) != ct || mapT.get(ct) != cs) {
                    return false;
                } else {
                    continue;
                }
            }

            // one map has mapping while the other one does not
            return false;
        }

        return true;
    }
}
