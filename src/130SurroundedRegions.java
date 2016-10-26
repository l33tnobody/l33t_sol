public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m==0) return;
        int n = board[0].length;

        for(int j=0; j<n; j++) {
            dfsboundry(board, 0, j, m, n);
            if (m>1)
                dfsboundry(board, m-1, j, m, n);
        }

        for(int i=1; i<m-1; i++) {
            dfsboundry(board, i, 0, m, n);
            if (n>1)
                dfsboundry(board, i, n-1, m, n);
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if (board[i][j]=='O'){
                    board[i][j]='X';
                } else if (board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfsboundry(char[][] board, int i, int j, int m, int n) {
        if (board[i][j] != 'O') return;

        board[i][j] = '1';
        if (i>1) // avoid stack overflow, the first row has been processed, no need to do it again.
            dfsboundry(board, i-1, j, m, n);
        if (i<m-2) // avoid stack overflow, the last row has been processed, no need to do it again.
            dfsboundry(board, i+1, j, m, n);
        if (j>1) // same ^
            dfsboundry(board, i, j-1, m, n);
        if (j<n-2) // same ^
            dfsboundry(board, i, j+1, m, n);
    }
}
