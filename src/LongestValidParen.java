public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int maxlen=0;
        int last=-1;
        
        Stack<Integer> lefts=new Stack<Integer>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')    lefts.push(i);
            else {  //')'
                if(lefts.isEmpty()) last=i;
                else{
                    lefts.pop();
                    if(lefts.isEmpty())
                        maxlen=Math.max(maxlen,i-last);
                    else
                        maxlen=Math.max(maxlen,i-lefts.peek());
                }
            }
        }
        
        return maxlen;
    }
}
