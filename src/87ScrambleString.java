// understand the question: the dividing point will not be changed not matter how to scramble
// recursive:
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        // check if made of same number of same letters to prune
        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        for (int i=1; i<s1.length(); i++) {
            if (
                  (isScramble(s1.substring(0,i), s2.substring(0,i))
                     && isScramble(s1.substring(i), s2.substring(i)))
                   ||
                  (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                     && isScramble(s1.substring(i), s2.substring(0,s2.length()-i)))
               )
                return true;
        }
        return false;
    }
}

// dp:
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;

        int n=s1.length();
        if(n!=s2.length()) return false;

        boolean[][][] dptable = new boolean[n][n][n]; //dptable[i][j][l] is true only when words starting from i and j of length l are scramble of each other.

        for (int l=0; l<n; l++) {   //real length minus one， +l will get the last element
            for (int i=0; i+l<n; i++) {
                for (int j=0; j+l<n; j++) {
                    if(l==0) { dptable[i][j][l] = (s1.charAt(i)==s2.charAt(j)); continue; }

                    for(int k=0; k<l; k++) { //sub length
                        if((dptable[i][j][k] && dptable[i+k+1][j+k+1][l-k-1])
                            || (dptable[i][j+l-k][k] && dptable[i+k+1][j][l-k-1])) {
                                dptable[i][j][l]=true;
                                break;
                        }
                    }
                }
            }
        }

        return dptable[0][0][n-1];
    }
}
