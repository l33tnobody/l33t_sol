public class Solution {
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int[] longestPath(TreeNode root) {
        if(root == null) return new int[]{0, 0};

        int dec = 1, inc = 1;
        if(root.left != null) {
            int[] l = longestPath(root.left);
            if(root.val == root.left.val + 1) dec = l[0] + 1;
            else if(root.val == root.left.val - 1) inc = l[1] + 1;
        }

        if(root.right != null) {
            int[] r = longestPath(root.right);
            if(root.val == root.right.val + 1) dec = Math.max(dec, r[0] + 1);
            else if(root.val == root.right.val - 1) inc = Math.max(inc, r[1] + 1);
        }

        max = Math.max(max, inc + dec - 1);
        return new int[]{dec, inc};
    }
}
