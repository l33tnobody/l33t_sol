public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (path == null || path.length() == 0) return "/";
        
        Stack<String> stack = new Stack<String>();
        String[] splits = path.trim().split("/");
        for (String s : splits) {
            if (s == null || s.length() == 0 || s.equals(".")) ;    //do nothing
            else if (s.equals("..")) {
                // Pop if stack is not empty;
                if (stack.size() > 0) stack.pop();
            }
            else {
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
