public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid.length==0||grid[0].length==0)   return 0;
        int m=grid.length;
        int n=grid[0].length;
        int[] lastrowres=new int[n];
        for(int i=1; i<n; i++)   lastrowres[i]=Integer.MAX_VALUE;
        lastrowres[0]=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                lastrowres[j]= Math.min(lastrowres[j], ((j-1<0)?Integer.MAX_VALUE:lastrowres[j-1])) + grid[i][j];
            }
        }
        
        return lastrowres[n-1];
    }
}
