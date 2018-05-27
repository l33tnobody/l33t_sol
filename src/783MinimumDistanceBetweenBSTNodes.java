class Solution {
    int mindiff = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return mindiff;
    }

    private void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        if(prev != null) mindiff = Math.min(mindiff, root.val - prev.val);
        prev = root;
        inorder(root.right);
    }
}
