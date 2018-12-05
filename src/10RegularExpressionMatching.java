// dp
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true; // empty matches empty

        for (int i = 0; i < p.length(); i++) { // only * is possibly matches empty string
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        // first column but 0 is all false implied here

        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1]; // has to treat x* as empty string
                    } else { // x matches s.charAt(i)
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]; // x* match s.charAt(i): once || more than once || 0 time
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}





// recursion
public class Solution {
    public boolean isMatch(String s, String p) {
        int i=0;
        int j=0;

        return isMatchRecur(s, p, i, j);
    }

    public boolean isMatchRecur(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();

        //no '*' following
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if(i == s.length()) return false;

            if(!(p.charAt(j) == s.charAt(i) || (p.charAt(j)=='.')))
                return false;

            return isMatchRecur(s, p, i+1, j+1);
        }

        //'*' follows next in p
        int orig_i = i;
        while(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')) {
            if (isMatchRecur(s, p, i+1, j+2)) return true;
            i++;
        }
        i = orig_i;

        // match 0 of p.charAt(j);
        return isMatchRecur(s, p, i, j+2);
    }
}

// original version
// public class Solution {
//     public boolean isMatch(String s, String p) {
//         assert s!=null&&p!=null;
//
//         int i=0; int j=0;
//         return isMatchRecur(s,p,i,j);
//     }
//
//     public boolean isMatchRecur(String s, String p, int i, int j) {
//         if (j==p.length()) return i==s.length();
//
//         assert p.charAt(j)!='*';
//         //no '*' following
//         if (j==p.length()-1 || p.charAt(j+1)!='*') {
//             if(i==s.length()) return false;
//             if(!(p.charAt(j)==s.charAt(i)||(p.charAt(j)=='.')))
//                 return false;
//             return isMatchRecur(s,p,i+1,j+1);
//         }
//
//         //'*' follows next in p
//         while((i<s.length()&&p.charAt(j)==s.charAt(i)) || p.charAt(j)=='.'&&i<s.length()){
//             if (isMatchRecur(s,p,i,j+2)) return true;
//             return isMatchRecur(s,p,i+1,j); // i++ ?
//         }
//         return isMatchRecur(s,p,i,j+2);
//     }
// }
