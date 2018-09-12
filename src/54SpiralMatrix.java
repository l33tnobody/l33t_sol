// a rewrite:
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int rowstart = 0;
        int rowend = matrix.length - 1;
        int colstart = 0;
        int colend = matrix[0].length - 1;
        
        while(true) {
            // left to right
            for(int j = colstart; j <= colend; j++) res.add(matrix[rowstart][j]);
            rowstart++;
            if(rowstart > rowend) break;
            
            // top to down
            for(int i = rowstart; i <= rowend; i++) res.add(matrix[i][colend]);
            colend--;
            if(colend < colstart) break;
            
            // right to left
            for(int j = colend; j >= colstart; j--) res.add(matrix[rowend][j]);
            rowend--;
            if(rowend < rowstart) break;
            
            // down to top
            for(int i = rowend; i >= rowstart; i--) res.add(matrix[i][colstart]);
            colstart++;
            if(colstart > colend) break;
        }
        
        return res;
    }
}

// original:
public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
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
