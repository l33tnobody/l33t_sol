class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        int res = 0;
        char sign = '+';
        int val = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while(i<s.length()) {
            while(i<s.length() && Character.isDigit(s.charAt(i))) {
                val = val*10 + (s.charAt(i) - '0');
                i++;
            }

            //new sign or out of bound
            if(sign=='+') stack.push(val);
            else if(sign=='-') stack.push(-1*val);
            else if(sign=='*') stack.push(stack.pop()*val);
            else if(sign=='/') stack.push(stack.pop()/val);

            if(i<s.length()) {
                sign = s.charAt(i);
                val = 0;
                i++;
            }
        }

        while(!stack.isEmpty()) {
            res+=stack.pop();
        }

        return res;
    }
}
