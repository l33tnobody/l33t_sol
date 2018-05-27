// sliding window
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if(allZero(count)) return true;

        for(int i=len1; i<len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if(allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for(int n : count) {
            if(n != 0) return false;
        }
        return true;
    }
}

// or faster way, keep an counter rather than go through all the chars
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] map = new int[26];

        for(char c : s1.toCharArray()) {
            map[c - 'a']++;
        }

        int l=0, r=0, count=s1.length();
        while(r<s1.length()) {
            int ri = s2.charAt(r) - 'a';
            if(map[ri] > 0) count--;
            map[ri]--;
            r++;

            if(count==0) return true;

            if(r-l == s1.length()) {
                int li = s2.charAt(l) - 'a';
                if (map[li]>=0) count++;
                map[li]++;
                l++;
            }
        }

        return false;
}
