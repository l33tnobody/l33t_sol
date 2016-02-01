public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word == null || word.length() == 0) return true;
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(DFS(board, i, j, word, 0, visited)) return true;
        return false;
    }
    
    public boolean DFS(char[][] b, int i, int j, String word, int index, boolean[][] v){
        if(v[i][j] || b[i][j] != word.charAt(index)) return false;
        v[i][j] = true;
        if(index == word.length() - 1) return true;
        
        if(i != 0 && DFS(b, i - 1, j, word, index + 1, v)) return true;
        if(i != b.length - 1 && DFS(b, i + 1, j, word, index + 1, v)) return true;
        if(j != 0 && DFS(b, i, j - 1, word, index + 1, v)) return true;
        if(j != b[0].length - 1 && DFS(b, i, j + 1, word, index + 1, v)) return true;
        
        v[i][j] = false;
        return false;
    }
}
