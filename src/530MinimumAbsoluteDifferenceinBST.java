class Solution {
    // in-order traversal recursively, or flatten to a list and compare the adjacent two
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(prev != null) min = Math.min(min, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}
