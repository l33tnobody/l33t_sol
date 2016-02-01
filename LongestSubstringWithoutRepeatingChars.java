public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i=0;
        int j=0;
        int maxlen=0;
        boolean[] exist = new boolean[256];
        final int n=s.length();
        
        while(j<n){
            if (exist[s.charAt(j) - 'a']){
                maxlen = Math.max(maxlen, j-i);
                while(s.charAt(i)!=s.charAt(j)){
                    exist[s.charAt(i) - 'a'] = false;
                    i++;
                }
                i++;
                j++;
                continue;
            } else {
                exist[s.charAt(j) - 'a'] = true;
                j++;
            }
        }
        maxlen = Math.max(maxlen,n-i);
        return maxlen;
        
    }
}
