class Solution {
    public String reverseStr(String s, int k) {
        char[] charr = s.toCharArray();
        
        for(int start = 0; start < charr.length; start += 2*k) {
            int i = start, j = Math.min(start + k - 1, s.length() - 1);
            while(i < j) {
                char t = charr[i];
                charr[i] = charr[j];
                charr[j] = t;
                i++; j--;
            }
        }
        
        return new String(charr);
    }
}