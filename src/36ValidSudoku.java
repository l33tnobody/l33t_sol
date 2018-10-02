class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char c = board[i][j]; 
                if(c == '.') continue;
                
                int v = c-'1';    //convert to index value;
                if(rows[i][v] || cols[j][v] || blocks[i/3*3 + j/3][v]) return false; // or blocks[i-i%3+j/3][v]
                else{
                    rows[i][v] = true; cols[j][v] = true; blocks[i/3*3 + j/3][v]=true;
                }
            }
        }
        
        return true;
    }
}