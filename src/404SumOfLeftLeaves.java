class Solution {
    private int sum = 0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return sum;
        
        if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;
    }
}

// iterative: 
class Solution {   
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        int res = 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode n = st.pop();
            if(n.right != null) st.push(n.right);
            if(n.left != null) {
                if(n.left.left == null && n.left.right == null) res += n.left.val;
                st.push(n.left);
            }
        }
        
        return res;
    }
}