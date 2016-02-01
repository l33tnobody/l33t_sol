public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res=new ArrayList<String[]>();
        if(n<=0) return res;
        int[] columns=new int[n];
        for(int i=0;i<n;i++)    columns[i]=-1;
        solveRecur(columns,0,res);
        return res;
    }
    
    private static void solveRecur(int[] columns, int currow, ArrayList<String[]> res){
        if(currow==columns.length){
            printUtil(res, columns);
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
    
    private static void printUtil(ArrayList<String[]> res, int[] columns){
        String[] curres=new String[columns.length];        
        for(int i=0;i<columns.length;i++){  //i th row
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<columns.length;j++){  //j th col
                if(j!=columns[i]) sb.append('.');
                else sb.append('Q');
            }
            curres[i]=sb.toString();
        }
        res.add(curres);
    }
    
}
