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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;

        return helper(nums, 0, len-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if(l>r) return null;

        int mid=l+(r-l)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = helper(nums, l, mid-1);
        n.right = helper(nums, mid+1, r);
        return n;
    }
}
