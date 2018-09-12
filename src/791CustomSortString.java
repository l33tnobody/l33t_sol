// count sort:
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        
        for (char c : T.toCharArray()) count[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) while (count[c - 'a'] > 0) { 
            sb.append(c); 
            count[c - 'a']--;
        }
        for(char c = 'a'; c <= 'z'; c++) {
            while(count[c - 'a'] > 0) {
                sb.append(c); 
                count[c - 'a']--;
            }
        }
        
        return sb.toString();
    }
}

// custom order sort: nlogn (original thought)
class Solution {
    public String customSortString(String S, String T) {
        int[] order = new int[26];
        Arrays.fill(order, 26);
        
        for(int i = 0; i < S.length(); i++) {
            order[S.charAt(i) - 'a'] = i;
        }
        
        char[] tmpchars = T.toCharArray();
        Character[] tchars = new Character[tmpchars.length];
        for(int i = 0; i < tchars.length; i++) tchars[i] = new Character(tmpchars[i]);
        Arrays.sort(tchars, (cha, chb) -> (order[cha - 'a'] - order[chb - 'a']));
        for(int i = 0; i < tchars.length; i++) tmpchars[i] = tchars[i].charValue();
        
        return new String(tmpchars);
    }
}