// O(n^2)
class Solution {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j < strs.length; j++) {
                if (j == i)
                    continue;
                if (isSubsequence(strs[j], strs[i]))
                    break;
            }
            if (j == strs.length) res = Math.max(res, strs[i].length());
        }
        return res;
    }
    
    public boolean isSubsequence(String a, String b) {
        if(b.length() > a.length()) return false;

        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }
}

// also O(n^2): more sophisticated sorting based length descendingly
class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        
        Set<String> duplicates = getDuplicates(strs);
        for(int i = 0; i < strs.length; i++) {
            if(!duplicates.contains(strs[i])) {
                int j = 0;
                for(; j < i; j++) {
                    if(isSubsequence(strs[j], strs[i])) break;       
                }
                if(j == i) return strs[i].length();
            }
        }

        return -1;
    }
    
    public boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) j++;
            i++;
        }
        return j == b.length();
    }
    
    private Set<String> getDuplicates(String[] strs) {
        Set<String> set = new HashSet<String>();
        Set<String> duplicates = new HashSet<String>();
        for(String s : strs) {
            if(set.contains(s)) duplicates.add(s);
            set.add(s);
        }
        return duplicates;
    }
}
