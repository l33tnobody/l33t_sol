class Solution {
    public int maxProduct(String[] words) {
        // if (words == null || words.length == 0) return 0; // no need for this

        int len = words.length;
        int[] bitmap = new int[len]; // bitmap of which char the word has or not
        for (int i = 0; i < len; i++) {
            String w = words[i];
            for(int j = 0; j < w.length(); j++) {
                bitmap[i] |= 1 << w.charAt(j) - 'a';
            }
        }

        int maxp = 0;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                if((bitmap[i] & bitmap[j]) == 0) {
                    maxp = Math.max(maxp, words[i].length() * words[j].length());
                }
            }
        }

        return maxp;
    }
}
