public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=s1.length();
        int n=s2.length();
        if (m+n!=s3.length())   return false;
        
        boolean[][] dptable=new boolean[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                
                if(i==0 && j==0)    dptable[i][j]=true;
                else if(i==0 && s2.charAt(j-1)==s3.charAt(j-1))  dptable[i][j]=dptable[i][j-1];
                else if(j==0 && s1.charAt(i-1)==s3.charAt(i-1))  dptable[i][j]=dptable[i-1][j];
                else if(i-1>=0 && j-1>=0 && s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)!=s3.charAt(i+j-1))    dptable[i][j]=dptable[i-1][j];
                else if(i-1>=0 && j-1>=0 && s1.charAt(i-1)!=s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1))    dptable[i][j]=dptable[i][j-1];
                else if(i-1>=0 && j-1>=0 && s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1))    dptable[i][j]=(dptable[i-1][j] || dptable[i][j-1]);
            }
        }
        
        return dptable[m][n];       
    }
}
