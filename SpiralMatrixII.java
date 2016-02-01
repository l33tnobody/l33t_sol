public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] res=new int[n][n];
        
        int beginX=0; int endX=n-1;
        int beginY=0; int endY=n-1;
        int num=1;

        while(true){
            //left to right
            for(int i=beginX;i<=endX;i++)   res[beginY][i]=num++;
            if(++beginY>endY) break;
            //top to down
            for(int i=beginY;i<=endY;i++)   res[i][endX]=num++;
            if(--endX<beginX) break;
            //right to left
            for(int i=endX;i>=beginX;i--)   res[endY][i]=num++;
            if(--endY<beginY) break;
            //down to top
            for(int i=endY;i>=beginY;i--)   res[i][beginX]=num++;
            if(++beginX>endX) break;            
        }
        return res;

    }
}
