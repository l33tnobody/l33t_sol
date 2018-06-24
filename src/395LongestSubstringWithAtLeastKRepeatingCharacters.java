// just for fun question:
// O(n*n) worst case
class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        return helper(str, 0, s.length(), k);
    }
    
    private int helper(char[] str, int start, int end, int k) {
        if (end - start < k) return 0;// substring length shorter than k
        
        int[] count = new int [26];
        for (int i = start; i<end; i++) {
            int idx = str[i] - 'a';
            count[idx]++;
        }
        boolean valid = true;
        for(int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                valid = false;
                break;
            }
        }
        if(valid) return end - start;
        
        int res = 0;
        int s = start;
        for (int i = start; i < end; i++) {
            int idx = str[i] - 'a';
            if (count[idx] < k) {
                res = Math.max(res, helper(str, s, i, k));
                s = i + 1;
            }
        }
        
        return Math.max(res, helper(str, s, end, k));
    }
}

// a special two-pointer/sliding window solution, try each possible number of unique chars in substring:
// just for fun:
// O(n)
class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;
        
        for (h = 1; h <= 26; h++) { // try each possible number of unique chars in the substring
            Arrays.fill(counts, 0);
            i = 0; 
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }
        
        return max;
    }
}