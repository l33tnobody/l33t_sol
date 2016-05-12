/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
