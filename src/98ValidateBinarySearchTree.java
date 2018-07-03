class Solution {
    public boolean isValidBST(TreeNode root) {
        return recur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean recur(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return recur(root.left, min, root.val) && recur(root.right, root.val, max);
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        // stack in order traversal
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null; // compare pre with cur
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(pre != null && pre.val >= cur.val) return false; // do something to the cur node in the in-order traversal order 
                pre = cur;
                cur = cur.right;
            }
        }
        
        return true;
    }
}