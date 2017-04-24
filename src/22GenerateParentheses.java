public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        char[] buf=new char[2*n];
        genParenRecur(res,buf,n,n,0);
        return res;
    }

    private void genParenRecur(List<String> res, char[] buf, int leftRemaining, int rightRemaining, int index) {
        if(leftRemaining > rightRemaining || leftRemaining < 0)   return; //invalid status leftRemaining has to be <= rightRemaining at all time

        if(leftRemaining==0 && rightRemaining==0) {
            res.add(String.copyValueOf(buf));
            return;
        }

        if(leftRemaining > 0) {
            buf[index] = '(';
            genParenRecur(res, buf, leftRemaining-1, rightRemaining, index+1);
        }

        if(rightRemaining > leftRemaining) {
            buf[index] = ')';
            genParenRecur(res, buf, leftRemaining, rightRemaining-1, index+1);
        }
    }
}
