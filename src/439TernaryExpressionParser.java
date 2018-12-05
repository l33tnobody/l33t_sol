// the key is to go from right to left and using a stack to record all chars and select when there is (X?)
public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";

        Stack<Character> st = new Stack<>();

        for(int i=expression.length()-1; i>=0; i--) { // starting from the end to group the right
            char c = expression.charAt(i);

            if (!st.isEmpty() && st.peek() == '?') {
                st.pop(); // pop '?'
                char first = st.pop();
                st.pop(); // pop ':'
                char second = st.pop();

                if (c == 'T') st.push(first);
                else st.push(second);
            } else {
                st.push(c);
            }
        }

        return String.valueOf(st.peek()); // has to be a single char according to input
    }
}
