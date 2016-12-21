public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode helper(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
        if (prestart>preorder.length-1 || instart>inend) return null;

        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);
        int inrootidx = 0;
        for(int i=instart; i<=inend; i++) {
            if(inorder[i] == rootval) {
                inrootidx = i;
            }
        }
        root.left = helper(prestart+1, instart, inrootidx-1, preorder, inorder);
        root.right = helper(prestart+inrootidx-instart+1, inrootidx+1, inend, preorder, inorder);

        return root;
    }
}
