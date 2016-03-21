// Math.pow requires doubles, returns a double
public class Solution {
    public int titleToNumber(String s) {
        int ALPHABET=26;
        int n=s.length();
        char[] letters = s.toCharArray();
        int num=0;

        for(int i=0; i<n; i++){
            int d=letters[i]-'A'+1;
            num+=d*(int)Math.pow(ALPHABET, n-1-i);
        }

        return num;
    }
}
