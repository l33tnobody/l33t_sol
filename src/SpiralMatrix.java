public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (matrix.length==0||matrix[0].length==0)   return res;
        int beginX=0; int endX=matrix[0].length-1;
        int beginY=0; int endY=matrix.length-1;
        
        while(true){
            //left to right
            for(int i=beginX;i<=endX;i++)   res.add(matrix[beginY][i]);
            if(++beginY>endY) break;
            //top to down
            for(int i=beginY;i<=endY;i++)   res.add(matrix[i][endX]);
            if(--endX<beginX) break;
            //right to left
            for(int i=endX;i>=beginX;i--)   res.add(matrix[endY][i]);
            if(--endY<beginY) break;
            //down to top
            for(int i=endY;i>=beginY;i--)   res.add(matrix[i][beginX]);
            if(++beginX>endX) break;            
        }
        return res;
        
    }
}
