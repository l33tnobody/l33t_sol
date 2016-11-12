public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] cut = new int[len];
        boolean[][] pal = new boolean[len][len];

        for(int i=0; i<len; i++){
            int min=i;
            for(int j=0; j<=i; j++){
                if(s.charAt(j)==s.charAt(i) && (i-j<=2 || pal[j+1][i-1])){
                    // j to i is a palindrome
                    pal[j][i]=true;
                    min = (j==0) ? 0 : Math.min(min, cut[j-1]+1);
                }
            }
            cut[i]=min;
        }

        return cut[len-1];
    }
}

// expand from the center dp, n^2
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] cut = new int[len+1];
        for(int i=0; i<len+1; i++) {
            cut[i] = i-1; // max possible cuts needed, cut[0]==-1
        }

        for(int i=0; i<len; i++) {
            // odd length palindrome
            for(int j=0; i-j>=0 && i+j<len && s.charAt(i-j)==s.charAt(i+j); j++) {
                cut[i+j+1] = Math.min(cut[i+j+1], 1+cut[i-j]);
            }
            // even length palindrome
            for(int j=1; i-j+1>=0 && i+j<len && s.charAt(i-j+1)==s.charAt(i+j); j++) {
                cut[i+j+1] = Math.min(cut[i+j+1], 1+cut[i-j+1]);
            }
        }
        return cut[len];
    }
}
