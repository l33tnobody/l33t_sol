// reverse in-order:

// recursive
class Solution {
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    private void convert(TreeNode cur) {
        if(cur == null) return;
        
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}

// iterative
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode cur = root;
        Stack<TreeNode> st = new Stack<>();
        
        while(cur != null || !st.isEmpty()) {
            if(cur != null) {
                st.push(cur);
                cur = cur.right;
            } else {
                cur = st.pop();
                cur.val += sum;
                sum = cur.val;
                cur = cur.left;
            }
        }
        
        return root;
    }
}