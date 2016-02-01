public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.equals(s2)) return true;
        
        int n=s1.length();
        if(n!=s2.length()) return false;
        
        boolean[][][] dptable=new boolean[n][n][n]; //dptable[i][j][l] is true only when words starting from i and j of length l are scramble of each other.
        
        for (int l=0; l<n; l++) {   //real length minus one
            for (int i=0; i+l<n; i++) {
                for (int j=0; j+l<n; j++) {
                    if(l==0)    {dptable[i][j][l]=(s1.charAt(i)==s2.charAt(j)); continue;}
                    
                    for(int k=0; k<l; k++){ //sub length
                        if((dptable[i][j][k]&&dptable[i+k+1][j+k+1][l-k-1]) 
                            || (dptable[i][j+l-k][k]&&dptable[i+k+1][j][l-k-1])) {
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
