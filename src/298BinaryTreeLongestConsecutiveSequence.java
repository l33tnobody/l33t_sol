public class Solution {
    private int max=0;

    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;

        helper(root, 0, root.val);
        return max;
    }

    private void helper(TreeNode root, int cur, int target) {
        if(root == null) return;

        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(max, cur);

        helper(root.left, cur, root.val+1);
        helper(root.right, cur, root.val+1);
    }
}
