class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows=new boolean[9][9];
        boolean[][] cols=new boolean[9][9];
        boolean[][] myblocks=new boolean[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c = board[i][j]; 
                if(c == '.') continue;
                int v = c - '1';    //convert to index value;
                rows[i][v] = cols[j][v] = myblocks[i - i%3 + j/3][v] = true;
            }
        }

        solveRecur(board, 0, rows, cols, myblocks);
    }

    private boolean solveRecur(char[][] board, int index, boolean[][] rows, boolean[][] cols, boolean[][] myblocks) {
        while(index<81 && board[index/9][index%9] != '.') index++;
        if(index==81)   return true;

        int r=index/9, c=index%9;
        for(int v=0;v<9;v++){
            if(rows[r][v]||cols[c][v]||myblocks[r-r%3+c/3][v])    continue;
            rows[r][v]=cols[c][v]=myblocks[r-r%3+c/3][v]=true;
            board[r][c]=Integer.toString(v+1).charAt(0);
            if(solveRecur(board,index+1,rows,cols,myblocks))   return true;
            rows[r][v]=cols[c][v]=myblocks[r-r%3+c/3][v]=false;
            board[r][c]='.';
        }
        return false;
    }
}