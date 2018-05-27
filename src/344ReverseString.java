class Solution {
    public String reverseString(String s) {
        char[] strarr = s.toCharArray();
        int l = 0, r = s.length() - 1;

        while(l < r) {
            char t = strarr[l];
            strarr[l] = strarr[r];
            strarr[r] = t;
            l++;
            r--;
        }

        return new String(strarr);
    }
}
