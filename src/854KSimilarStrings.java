class Solution {
    public int kSimilarity(String A, String B) {
        if(A.equals(B)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(A);
        q.add(A);
        int res = 0;
        
        while(!q.isEmpty()) {
            res++;
            
            for(int size = q.size(); size > 0; size--) {
                String s = q.poll();
                int i = 0;
                while(s.charAt(i) == B.charAt(i)) i++;
                for(int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(i) != B.charAt(j) || s.charAt(j) == B.charAt(j) || s.charAt(i) == s.charAt(j)) continue;
                    String tmp = swap(s, i, j);
                    if(tmp.equals(B)) return res;
                    if(visited.add(tmp)) q.add(tmp);
                }
            }
        }
        
        return res; // it should never reach here for anagrams
    }
    
    private String swap(String str, int i, int j) {
        char[] carr = str.toCharArray();
        char t = carr[i];
        carr[i] = carr[j];
        carr[j] = t;
        return new String(carr);
    }
}