public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] mapping = new String[26];
        HashMap<String, Character> wordToChar = new HashMap<String, Character>();
        int i=0;
        int j=0;
        int k=0;

        while(i<pattern.length() && j<str.length()) {
            char c = pattern.charAt(i);
            int index = c - 'a';

            while(k<str.length() && str.charAt(k) != ' '){
                k++;
            }
            String word = str.substring(j,k);

            if (mapping[index] == null){
                if (wordToChar.containsKey(word)){
                    return false;
                } else {
                    wordToChar.put(word, c);
                }
                mapping[index]=word;

            } else if (!mapping[index].equals(word)){
                return false;
            }

            i++;
            j=k+1;
            k=j;
        }

        if (j<str.length() || i<pattern.length()) //excess chars on either patter or str
            return false;

        return true;
    }
}
