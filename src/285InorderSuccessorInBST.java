public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode r = p.right;
            while(r.left != null) {
                r = r.left;
            }
            return r;
        }

        TreeNode rightParent = null;    // lowest parent on the right side
        while(root != null) {
            if (root.val == p.val) break;
            if (p.val < root.val) {
                rightParent = root;
                root = root.left;
            } else{
                root = root.right;
            }
        }

        return rightParent;
    }
}

// amazingly this simpler iterative works
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode res = null;
    while(root!=null) {
        if(p.val < root.val) {
        	res = root;
        	root = root.left;
        }
        else root = root.right;
    }
    return res;
}
