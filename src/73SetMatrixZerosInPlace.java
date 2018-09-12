public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(rows==0||cols==0)  return;
        
        boolean fr0=false, fc0=false;
        for(int i=0; i<cols; i++)
            if(matrix[0][i]==0){fr0=true; break;}
        for(int i=0; i<rows; i++)
            if(matrix[i][0]==0){fc0=true; break;}
            
        
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][j]==0){ matrix[i][0]=0; matrix[0][j]=0;}
            }
        }
        
        for(int i=1; i<rows; i++){
            if(matrix[i][0]==0)
                for(int j=1; j<cols; j++)   matrix[i][j]=0;
        }
        for(int j=1; j<cols; j++){
            if(matrix[0][j]==0)
                for(int i=1; i<rows; i++)   matrix[i][j]=0;
        }
        
        if(fr0)
            for(int j=0; j<cols; j++) matrix[0][j]=0;
        if(fc0)
            for(int i=0; i<rows; i++) matrix[i][0]=0;
        
    }
}
