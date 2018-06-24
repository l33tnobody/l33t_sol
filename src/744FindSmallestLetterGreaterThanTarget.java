// same as greaterKey:
// a better more clearer solution:
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        
        return letters[hi % letters.length];
    }
}



class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(letters[n - 1] <= target) return letters[0];
        
        int l = 0, h = n - 1;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(letters[mid] <= target) l = mid + 1;
            else h = mid;
        }
        
        return letters[h];
    }
}