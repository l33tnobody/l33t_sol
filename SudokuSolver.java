public class Solution {
            // DO NOT write main() function
    private boolean[][] rows=new boolean[9][9];
    private boolean[][] cols=new boolean[9][9];
    private boolean[][] myblocks=new boolean[9][9];
    
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        
        clearRes();
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j]; 
                if(c=='.') continue;
                int v=c-'1';    //convert to index value;
                rows[i][v]=cols[j][v]=myblocks[i-i%3+j/3][v]=true;
            }
        }
        
        solveRecur(board,0);
    }
    
    private void clearRes(){
        for(int i=0;i<9;i++){   //clear results from last use
            for(int j=0;j<9;j++){
                rows[i][j]=false;
                cols[i][j]=false;
                myblocks[i][j]=false;       
            }
        }     
    }
    
    private boolean solveRecur(char[][] board, int index){
        while(index<81&&board[index/9][index%9]!='.') index++;
        if(index==81)   return true;
               
        int r=index/9, c=index%9;
        for(int v=0;v<9;v++){
            if(rows[r][v]||cols[c][v]||myblocks[r-r%3+c/3][v])    continue;
            rows[r][v]=cols[c][v]=myblocks[r-r%3+c/3][v]=true;
            board[r][c]=Integer.toString(v+1).charAt(0);
            if(solveRecur(board,index+1))   return true;
            rows[r][v]=cols[c][v]=myblocks[r-r%3+c/3][v]=false;
            board[r][c]='.';
        }
        return false;
    }
}
