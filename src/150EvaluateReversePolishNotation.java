public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens) {
            switch(s) {
                case "+":
                    st.push(st.pop()+st.pop());
                    break;
                case "-":
                    int n2 = st.pop(), n1=st.pop();
                    st.push(n1-n2);
                    break;
                case "*":
                    st.push(st.pop()*st.pop());
                    break;
                case "/":
                    int n4 = st.pop(), n3=st.pop();
                    st.push(n3/n4);
                    break;
                default:
                    st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
    }
}
