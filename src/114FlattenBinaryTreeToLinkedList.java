// preorder traversal
class Solution {
    TreeNode cur = null;

    public void flatten(TreeNode root) {
        cur = root;
        h(root);
    }

    private void h(TreeNode root) {
        if (root == null)
            return;

        TreeNode l = root.left;
        TreeNode r = root.right;

        cur.left = null;
        if (l != null) {
            cur.right = l;
            cur = cur.right;
            h(cur);
        }

        if (r != null) {
            cur.right = r;
            cur = cur.right;
            h(cur);
        }
    }
}

// reverse pre-order: nice
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root==null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// FYI using a stack:
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr.right != null)
                stk.push(curr.right);
            if (curr.left != null)
                stk.push(curr.left);
            if (!stk.isEmpty())
                curr.right = stk.peek();
            curr.left = null;
        }
    }

}










// Iterative one:
public void flatten(TreeNode root) {
    while(root != null) {
        if (root.left!=null) {
            TreeNode left = root.left;
            while (left.right!=null)
                left = left.right;
            left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        root = root.right;
    }
}
