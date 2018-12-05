// better solution
public class Solution {
    public int rob(TreeNode root) {
        int[] res = robhelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robhelper(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robhelper(root.left);
        int[] right = robhelper(root.right);

        int[] res = new int[2];
        // not to rob root:
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // rob root:
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}
