class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if(firstParen == -1) return cur;
        
        int i = firstParen, leftParenCount = 0;
        for(; i<s.length(); i++) {
            if(s.charAt(i) == '(') leftParenCount++;
            else if(s.charAt(i) == ')') leftParenCount--;
            
            if(leftParenCount == 0) {
                cur.left = str2tree(s.substring(firstParen + 1, i));
                break;
            }
        }
        
        i++;
        if(i < s.length()) cur.right = str2tree(s.substring(i + 1, s.length() - 1));
        
        return cur;
    }
}