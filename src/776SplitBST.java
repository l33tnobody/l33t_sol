// straightforward recursive solution:
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[]{ null, null };

        TreeNode[] t;
        if(root.val <= V) {
            t = splitBST(root.right, V);
            root.right = t[0];
            t[0] = root;
        } else {
            t = splitBST(root.left, V);
            root.left = t[1];
            t[1] = root;
        }
        return t;
    }
}

// just for fun:
// We could find out that the smaller tree only update its right child.
// On the other hand, the larger tree always only update its left child.
class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode dummySm = new TreeNode(0);
        TreeNode curSm = dummySm;
        TreeNode dummyLg = new TreeNode(0);
        TreeNode curLg = dummyLg;

        while (root != null) {
            if (root.val <= V) {
                curSm.right = root;
                curSm = root;
                root = root.right;
                curSm.right = null;
            } else {
                curLg.left = root;
                curLg = root;
                root = root.left;
                curLg.left = null;
            }
        }
        return new TreeNode[] {dummySm.right, dummyLg.left};
    }
}
