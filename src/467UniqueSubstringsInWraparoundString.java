class Solution {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        int[] count = new int[26];

        // store longest contiguous substring ends at current position.
        int len = 0;
        for(int i=0; i<p.length(); i++) {
            if(i>0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1) - p.charAt(i) == 25 )) {
                len++;
            } else {
                len=1;
            }

            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], len);
        }

        int sum = 0;
        for(int n : count) {
            sum += n;
        }

        return sum;
    }
}
