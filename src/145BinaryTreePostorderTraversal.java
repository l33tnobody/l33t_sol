/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// stack iterative: https://discuss.leetcode.com/topic/30632/preorder-inorder-and-postorder-iteratively-summarization
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode p = root;

        while(!st.isEmpty() || p!=null){
            if(p!=null) {
                res.add(0, p.val);
                st.push(p);
                p=p.right;
            } else {
                p=st.pop();
                p=p.left;
            }
        }

        return res;
    }
}

// reverse add to result:
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();

        if (root==null) return res;

        st.push(root);
        while(!st.isEmpty()) {
            TreeNode n=st.pop();
            res.add(0, n.val);
            if(n.left!=null) st.push(n.left);
            if(n.right!=null) st.push(n.right);
        }

        return res;
    }
}

// pre-order traversal is root-left-right, and post order is left-right-root.
// modify the code for pre-order to make it root-right-left,
// and then reverse the output so that we can get left-right-root .
/*
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();

        if (root==null) return res;

        st.push(root);
        while(!st.isEmpty()) {
            TreeNode n = st.pop();
            res.add(n.val);
            if (n.left!=null) st.push(n.left);
            if (n.right!=null) st.push(n.right);
        }

        Collections.reverse(res);
        return res;
    }
}
*/

// recursive
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    private void postorder(List<Integer> res, TreeNode root) {
        if (root==null) return;
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }
}
