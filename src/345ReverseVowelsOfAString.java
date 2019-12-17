class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        char[] strarr = s.toCharArray();
        int len = s.length();
        int l = 0, r = len - 1;
        while(true) {
            while(l<len && !vowels.contains(strarr[l])) l++;
            while(r>=0 && !vowels.contains(strarr[r])) r--;

            if(l>=r) break;

            swap(strarr, l, r);
            l++;
            r--;
        }

        return new String(strarr);
    }

    private void swap(char[] strarr, int l, int r) {
        char t = strarr[l];
        strarr[l] = strarr[r];
        strarr[r] = t;
    }
}
