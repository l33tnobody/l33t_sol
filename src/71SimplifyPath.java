class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splits = path.trim().split("/");
        for (String s : splits) {
            if (s.length() == 0 || s.equals(".")) ;    //do nothing
            else if (s.equals("..")) {
                // Pop if stack is not empty;
                if (stack.size() > 0) stack.pop();
            } else {
                // Push all others to stack.
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuffer buf = new StringBuffer();
        while (!stack.isEmpty()) {
            buf.insert(0, stack.pop());
            buf.insert(0, "/");
        }

        return buf.toString();
    }
}
