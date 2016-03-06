public class Solution {
    // only the right most bit was used, use the second to right most bit to record the next state
    public void gameOfLife(int[][] board) {
        if (board==null || board.length==0)
            return;
        int m=board.length;
        int n=board[0].length;
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                int count=0;

                for (int ii=Math.max(0, i-1); ii<=Math.min(i+1, m-1); ii++){
                    for(int jj=Math.max(0, j-1); jj<=Math.min(n-1, j+1); jj++){
                        if (ii==i && jj==j) continue; // neighbors only
                        count += (board[ii][jj] & 1);
                    }
                }

                if (count==3) board[i][j] |= 2; // set the second bit
                else if (count==2 && board[i][j]==1) board[i][j] |= 2; // can be combined with the previous line
                // else dead and the second bit already 0
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                board[i][j] >>= 1;
            }
        }
    }
}
