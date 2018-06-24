public class Solution {
    int maxVal = Integer.MIN_VALUE; 

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxVal;
    }

    private int maxPathDown(TreeNode tn) {
        if (tn == null) return 0;
        int left = Math.max(0, maxPathDown(tn.left)); // possibly not through left child at all
        int right = Math.max(0, maxPathDown(tn.right)); // possibly not through right child at all
        int candidate = tn.val + left + right;
        if (candidate > maxVal) maxVal = candidate;
        return (tn.val + Math.max(left, right));
    }
}
