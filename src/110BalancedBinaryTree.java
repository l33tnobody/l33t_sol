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
    public boolean isBalanced(TreeNode root){
        return check(root) != -1;
    }

    private int check(TreeNode root){
        if (root == null)
            return 0;
        int hl = check(root.left);
        if (hl==-1) return -1;
        int hr = check(root.right);
        if (hr==-1) return -1;

        if (Math.abs(hl-hr) > 1) return -1;
        return Math.max(hl, hr) + 1;
    }
}
