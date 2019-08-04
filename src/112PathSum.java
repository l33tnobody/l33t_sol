public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    private boolean dfs(TreeNode root, int sum){
        if (root==null)
            return false;

        if (root.val == sum && isLeaf(root))
            return true;

        return dfs(root.left, sum-root.val) || dfs(root.right, sum-root.val);
    }

    private boolean isLeaf(TreeNode node){
        if (node.left==null && node.right==null)
            return true;
        return false;
    }
}

// better one:
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int base, int sum) {
        if (root == null)
            return false;

        int csum = base + root.val;
        if (root.left == null && root.right == null) {
            return csum == sum;
        }

        return dfs(root.left, csum, sum) || dfs(root.right, csum, sum);
    }
}
