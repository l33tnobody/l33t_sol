// one pass
public class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;

        while(true){

            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) j--;

            if (i>=j) break;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }

        return true;

    }
}

// filter and check
public class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> chars = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c))
                chars.add(Character.toLowerCase(c));
        }

        int i=0, j=chars.size()-1;

        while(i<j){
            if (chars.get(i) != chars.get(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
}
