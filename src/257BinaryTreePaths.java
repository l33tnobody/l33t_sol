class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String base, List<String> res) {
        if (root == null)
            return;

        String newBase = base.isEmpty() ? String.valueOf(root.val) : base + "->" + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            res.add(newBase);
            return;
        }

        dfs(root.left, newBase, res);
        dfs(root.right, newBase, res);
    }
}