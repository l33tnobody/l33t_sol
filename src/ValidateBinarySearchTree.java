/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isValidBSTRecur(TreeNode root, int min, int max){
        if(root==null) return true;
        
        if(root.val<=min || root.val>=max)   return false;
        
        return (isValidBSTRecur(root.left, min, root.val) && 
            isValidBSTRecur(root.right, root.val, max));
    }
}
