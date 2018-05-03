class Solution {
    public String reorganizeString(String S) { // essentailly the same as rearrange string k distance apart, where k = 2
        int[] count = new int[26];
        int[] valid = new int[26]; // next valid index to guarantee k distance apart
        for(int i=0; i<S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++) {
            int charpos = findValidMax(count, valid, i);
            if(charpos == -1) return "";
            count[charpos]--;
            valid[charpos] = i+2; // update next valid index
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
