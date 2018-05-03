// https://www.geeksforgeeks.org/expression-evaluation/
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = c - '0';
                i++;
                while(i<s.length() && Character.isDigit(s.charAt(i))) {
                    num = num *10 + s.charAt(i) - '0';
                    i++;
                }
                nums.push(num);
                num = 0;
                i--; // there is ++ in the for loop
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while(ops.peek() != '(') nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // remove the top '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // consolidate the stack before pushing the current op
                while(!ops.isEmpty() && hasPrecedence(ops.peek(), c)) nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));
                ops.push(c);
            }
        }

        while(!ops.isEmpty()) nums.push(applyOp(ops.pop(), nums.pop(), nums.pop()));

        return nums.pop();
    }

    private static int applyOp(char op, int b, int a) { // note int b is the first pop
        switch(op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }
        return 0;
    }

    private static boolean hasPrecedence(char top, char cur) { // true when top op has higher or equal precedence than the current op
        if(top == '(' || top == ')') return false;
        if((top == '+' || top == '-') && (cur == '*' || cur == '/')) return false;
        return true;
    }
}
