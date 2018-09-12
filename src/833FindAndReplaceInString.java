// use a map to store inverse index O(n*r)  r is the len of an avg replacement string
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>(); // from index in S to the index in targets/sources
        for(int i=0; i<indexes.length; i++) {
            if(S.startsWith(sources[i], indexes[i])) map.put(indexes[i], i);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < S.length()) {
            if(map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}

// or build invert index in an array and replace in place in a StringBuilder: same O(n*r) runtime
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder(S);
        int len = S.length();
        int[] indexValInvert = new int[len];
        Arrays.fill(indexValInvert, -1);
        for (int i = 0; i < indexes.length; ++i) indexValInvert[indexes[i]] = i;
        for (int i = len - 1; i >= 0; i--) {
            int j = indexValInvert[i];
            if (j < 0) continue;
            if (S.startsWith(sources[j], i)) {
                sb.replace(i, i + sources[j].length(), targets[j]);
            }
        }
        return sb.toString();
    }
}

// or sort indexes based on value (indexes in S) 
// for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
// Collections.sort(sorted, (a, b) -> a[0] - b[0]);
// and then iterate through append and/or replace