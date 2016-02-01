public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n<=0) return 1;
        int[] res=new int[1];   //number of different config
        res[0]=0;
        int[] columns=new int[n];
        for(int i=0;i<n;i++)    columns[i]=-1;
        solveRecur(columns,0,res);
        return res[0];
    }
    
    private static void solveRecur(int[] columns, int currow, int[] res){
        if(currow==columns.length){
            res[0]++;
            return;
        }
        for(int col=0;col<columns.length;col++){
            if(isValid(columns, currow, col)){
                columns[currow]=col;
                solveRecur(columns, currow+1, res);
                columns[currow]=-1;
            }
        }
    }
    
    private static boolean isValid(int[] columns, int currow, int col){
        //check previous rows
        for(int prerow=0;prerow<currow;prerow++){
            int precol=columns[prerow];
            if(precol==col)    return false;
            //check diagonal distance
            if(currow-prerow==Math.abs(col-precol)) return false;
        }
        return true;
    }
    
}
