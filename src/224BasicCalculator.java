class Solution {
    public int calculate(String s) {
        int res = 0;
        int number = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>(); // can use a single stack with both sign (1, -1) and result in it.

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                int j = i;
                while(j<s.length() && Character.isDigit(s.charAt(j))) {
                    number = number*10 + s.charAt(j) - '0';
                    j++;
                }
                res += sign*number;
                i = j-1;
                number = 0;
                // sign will be reassigned next or popped from the stack
            } else if(c == '+') {
                sign = 1;
            } else if(c == '-') {
                sign = -1;
            } else if(c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if(c == ')') {
                      // sign        // previous result
                res = res*st.pop() + st.pop();
                // sign will be reassigned next or popped from the stack
            }
        }

        return res;
    }
}

// stack on the actual sign only, plus based on numbers
public class Solution {
    public int calculate(String s) {
        int res=0, val=0, sign=1;
        Stack<Integer> st = new Stack<>(); //sign stack
        st.push(sign);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(sign*st.peek());
                sign=1;
            } else if (c == ')'){
                st.pop();
            } else if (c == '+'){
                sign = 1;
            } else if (c=='-'){
                sign = -1;
            } else if (c!=' '){
                //digits
                int j=i;
                for(; j<s.length() && isDigit(s.charAt(j)); j++){
                    val = 10*val + s.charAt(j) - '0';
                }
                i=j-1; // due to i++, make the next iteration i=j
                res+=sign*st.peek()*val;
                val=0;
            }
        }
        return res;
    }

    private boolean isDigit(char c){
        if (c>='0' && c<='9')
            return true;
        return false;
    }
}
