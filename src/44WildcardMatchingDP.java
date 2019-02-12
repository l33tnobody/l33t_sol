// dp:
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] ws = s.toCharArray();
        char[] wp = p.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for (int j = 1; j <= n; j++)
            dp[0][j] = dp[0][j-1] && wp[j-1] == '*';

        for (int i = 1; i <= m; i++)
            dp[i][0] = false;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
            	if (wp[j-1] == '?' || ws[i-1] == wp[j-1])
            		dp[i][j] = dp[i-1][j-1];
            	else if (wp[j-1] == '*')
            		dp[i][j] = dp[i-1][j] || dp[i][j-1]; // match once or more than once OR match 0 times
            }
        }

        return dp[m][n];
    }
}

// recursive: overlapping subproblems, can add caching
public class Solution {
    public boolean isMatch(String s, String p) {
        int netplen=0;
        for(int i=0;i<p.length();i++)
            if(p.charAt(i)!='*') netplen++;
        if(s.length()<netplen)  return false;

        //remove redundant consecutive '*'
        StringBuilder sb=new StringBuilder();
        if(p.length()>0){
            sb.append(p.charAt(0));
            for(int i=1;i<p.length();i++){
                if(p.charAt(i-1)=='*'&&p.charAt(i)=='*') continue;
                sb.append(p.charAt(i));
            }
        }

        int i=0; int j=0;
        return isMatchRecur(s,sb.toString(),i,j);
    }

    public boolean isMatchRecur(String s, String p, int i, int j){
        if (j==p.length()) return i==s.length();

        if(p.charAt(j)!='*'){
            if(i==s.length()) return false;
            if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))
                return isMatchRecur(s,p,i+1,j+1);
            return false;
        }
        // p at j =='*'
        if(i==s.length()) {
            return j==p.length()-1;
        }
        if(isMatchRecur(s,p,i,j+1)) return true;
        return isMatchRecur(s,p,i+1,j);

    }
}

// fyi: a greedy approach
// boolean comparison(String str, String pattern) {
//         int s = 0, p = 0, match = 0, starIdx = -1;
//         while (s < str.length()){
//             // advancing both pointers
//             if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
//                 s++;
//                 p++;
//             }
//             // * found, only advancing pattern pointer
//             else if (p < pattern.length() && pattern.charAt(p) == '*'){
//                 starIdx = p;
//                 match = s;
//                 p++;
//             }
//            // last pattern pointer was *, advancing string pointer match more s with *
//             else if (starIdx != -1){
//                 p = starIdx + 1;
//                 match++;
//                 s = match;
//             }
//            //current pattern pointer is not star, last patter pointer was not *
//           //characters do not match
//             else return false;
//         }
//
//         //check for remaining characters in pattern
//         while (p < pattern.length() && pattern.charAt(p) == '*')
//             p++;
//
//         return p == pattern.length();
// }


// original: couple of years ago
// public class Solution {
//     public boolean isMatch(String s, String p) {
//         if (s == null || p == null)  return false;
//
//         // calculate count for non-wildcard char
//         int count = 0;
//         for (Character c : p.toCharArray()) {
//             if (c != '*')  ++count;
//         }
//         // the count should not be larger than that of s
//         if (count > s.length())  return false;
//
//         boolean[] matches = new boolean[s.length()+1];
//         matches[0] = true;
//         int pid = 0, firstMatch = 0;
//         while (pid < p.length()) {
//             // skip duplicate '*'
//             if (pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {
//                 ++pid;
//                 continue;
//             }
//
//             // if '*', fill up the rest of row
//             if (p.charAt(pid) == '*') {
//                 // fill up the rest of row with true, up to the first match in previous row
//                 for (int i = firstMatch+1; i <= s.length(); ++i)  matches[i] = true;
//             } else {
//                 // fill up backwards:
//                 // - set to true if match current char and previous diagnal also match
//                 // - otherwise, set to false
//                 int match = -1;
//                 for (int i=s.length(); i>firstMatch; --i) {
//                     matches[i] = (p.charAt(pid) == '?'|| p.charAt(pid) == s.charAt(i-1))
//                                 && matches[i-1];
//                     if (matches[i])  match = i;
//                 }
//                 if (match < 0)  return false;
//                 firstMatch = match;
//             }
//
//             ++pid;
//         }
//
//         return matches[s.length()];
//     }
// }
