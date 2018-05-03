class Solution { // greedy try to fit the char with current highest count and valid position requirement
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        int[] valid = new int[26]; // next valid index to guarantee k distance apart
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int charpos = findValidMax(count, valid, i);
            if(charpos == -1) return "";
            count[charpos]--;
            valid[charpos] = i+k; // update next valid index
            sb.append((char) (charpos + 'a'));
        }

        return sb.toString();
    }

    // find the max count char that is valid for putting into pos i
    private int findValidMax(int[] count, int[] valid, int i) {
        int max = 0;
        int charpos = -1;
        for(int j=0; j<count.length; j++) {
            if(count[j] > 0 && count[j] > max && i >= valid[j]) {
                charpos = j;
                max = count[j];
            }
        }
        return charpos;
    }
}
