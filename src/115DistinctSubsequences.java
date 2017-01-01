// https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java/2
/*
 S 0123....j
T +----------+
0 |1111111111|
1 |0         |
2 |0         |
. |0         |
. |0         |
i |0         |

S[x] == T[y] ?
no:  mem[i+1][j+1] = mem[i+1][j]
yes: mem[i+1][j+1] = mem[i+1][j] + mem[i][j]
*/

public class Solution {
    public int numDistinct(String s, String t) {
        int [][] mem = new int[t.length()+1][s.length()+1];

        for(int j=0; j<s.length()+1; j++){
            mem[0][j] = 1;
        }

        for(int i=0; i<t.length(); i++){
            for(int j=0; j<s.length(); j++){
                if (t.charAt(i) != s.charAt(j)){
                    mem[i+1][j+1] = mem[i+1][j];
                } else {
                    mem[i+1][j+1] = mem[i+1][j] + mem[i][j];
                }
            }
        }

        return mem[t.length()][s.length()];
    }
}
