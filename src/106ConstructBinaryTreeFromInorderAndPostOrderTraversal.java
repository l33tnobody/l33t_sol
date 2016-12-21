// given preorder and postorder traversal, tree is not deterministic,
// meaning there could be more than one possible tree construct

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length-1, 0, inorder.length-1, inorder, postorder);
    }

    private TreeNode helper(int postend, int instart, int inend, int[] inorder, int[] postorder) {
        if (postend < 0 || instart > inend) return null;

        int rootval = postorder[postend];
        TreeNode root = new TreeNode(rootval);

        int inrootidx = 0;
        for(int i=instart; i<=inend; i++) {
            if (inorder[i] == rootval){
                inrootidx = i;
                break;
            }
        }

        root.right = helper(postend-1, inrootidx+1, inend, inorder, postorder);
        root.left = helper(postend-(inend-inrootidx)-1, instart, inrootidx-1, inorder, postorder);

        return root;
    }
}
