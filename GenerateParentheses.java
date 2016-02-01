public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        char[] buf=new char[2*n];
        genParenRecur(res,buf,n,n,0);
        return res;
    }
    
    private void genParenRecur(ArrayList<String> res, char[] buf, int leftRemaining, int rightRemaining, int index){
        if(leftRemaining<0||leftRemaining>rightRemaining)   return; //invalid status
        
        if(leftRemaining==0&&rightRemaining==0){
            res.add(String.copyValueOf(buf));
        }
        
        if(leftRemaining>0){
            buf[index]='(';
            genParenRecur(res,buf,leftRemaining-1,rightRemaining,index+1);
        }
        
        if(rightRemaining>leftRemaining){
            buf[index]=')';
            genParenRecur(res,buf,leftRemaining,rightRemaining-1,index+1);
        }
    }
}
