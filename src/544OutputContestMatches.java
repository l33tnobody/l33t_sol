// iterative solution is easier to come up with:
class Solution {
    public String findContestMatch(int n) {
        String[] res = new String[n];
        for(int i = 0; i < n; i++) res[i] = String.valueOf(i + 1);
        
        while(n != 1) {
            for(int i=0; i<n/2; i++) {
                res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
            }
            n /= 2;
        }
        
        return res[0];
    }
}

// recursion actually harder to come up with, use level as a argument to calculate the start of the second half:
class Solution {
    public String findContestMatch(int n) {
        return generateMatch(n, 1, 2);
    }
    
    private String generateMatch(int n, int lo, int level) {
        if (level == n)
            return "(" + lo + "," + (level + 1 - lo) + ")"; // n+1-lo
        return "(" + generateMatch(n, lo, level << 1) + "," + generateMatch(n, level + 1 - lo, level << 1) + ")";
    }
}