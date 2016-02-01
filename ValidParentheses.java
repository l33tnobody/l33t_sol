public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=s.length();
        if(n==0) return true;
        Stack<Character> st=new Stack<Character>();
        
        st.push(s.charAt(0));
        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            switch (c){
                case ')':
                    if(!st.empty()&&st.peek()=='(')
                        st.pop();
                    else return false;
                    break;
                case ']':
                    if(!st.empty()&&st.peek()=='[')
                        st.pop();
                    else return false;
                    break;
                case '}':
                    if(!st.empty()&&st.peek()=='{')
                        st.pop();
                    else return false;
                    break;
                default:    //check level and push to stack
/*  //check level of current paren, not required by test cases;
                    if(!st.empty()){
                        int prelevel=getLevel(st.peek());
                        int curlevel=getLevel(c);
                        if (curlevel>prelevel)  return false;
                    }
*/
                    st.push(c);
            }
        }
        
        if (!st.empty())    return false;
        
        return true;
    }
    
    private static int getLevel(char c){
        switch (c){
            case '(':
                return 1;
            case '[':
                return 2;
            case '{':
                return 3;
            default:
                assert false;
        }
        return -1;
    }
}
