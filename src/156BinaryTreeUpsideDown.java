
// iterative
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null)
            return root;

        TreeNode l=root.left;
        TreeNode r=root.right;
        root.left=null;
        root.right=null;

        while(l!=null) {
            TreeNode nl=l.left; // next left
            TreeNode nr=l.right; // next right

            l.right = root;
            l.left = r;

            root = l;
            l = nl;
            r = nr;
        }

        return root;
    }
}

//TODO: check discussion... for recursion?
