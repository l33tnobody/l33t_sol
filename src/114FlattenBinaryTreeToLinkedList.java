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
    private TreeNode cur = null;

    public void flatten(TreeNode root) {
        cur = root;
        flattenHelper(root);
    }

    private void flattenHelper(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        cur.left = null;

        if (left!=null) {
            cur.right = left;
            cur = cur.right;
        }
        flattenHelper(left);

        if (right!=null) {
            cur.right = right;
            cur = cur.right;
        }
        flattenHelper(right);
    }
}

// reverse pre-order
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


// FYI using a stack:
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode curr = stk.pop();
            if (curr.right!=null)
                 stk.push(curr.right);
            if (curr.left!=null)
                 stk.push(curr.left);
            if (!stk.isEmpty())
                 curr.right = stk.peek();
            curr.left = null;
        }
    }
}
