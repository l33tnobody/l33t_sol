// Math.pow requires doubles, returns a double
public class Solution {
    public int titleToNumber(String s) {
        int ALPHABET=26;
        int n=s.length();
        char[] letters = s.toCharArray();
        int num=0;

        int base=1;
        for(int i=n-1; i>=0; i--, base*=ALPHABET){
            int d=letters[i]-'A'+1;
            num+=d*base;
        }

        return num;
    }
}
