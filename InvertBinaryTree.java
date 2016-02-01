public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}


public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root!=null){
            TreeNode temp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = temp;
        }
        return root;
    }
}
