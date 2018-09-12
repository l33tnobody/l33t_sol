// greedy:
class Solution {
    public boolean checkValidString(String s) {
        // possible number of left parens: lowest to highest
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--; // if * is right paren
                high++; // if * is left paren or if count as nothing has no change in the middle
            }
            
            if (high < 0) {
                return false;
            }
            low = Math.max(low, 0);
        }
        return low == 0;
    }
}


// from left to right and then right to left: not very straight foward
class Solution {
    public boolean checkValidString(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*' || s.charAt(i) == '(') sum++;
            else sum--;
            if(sum < 0) return false;
        }
        
	    if(sum  ==  0) return true;
        
        sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '*' || s.charAt(i) == ')') sum++;
            else sum--;
            if(sum < 0) return false;
        }
        return true;
    }
}