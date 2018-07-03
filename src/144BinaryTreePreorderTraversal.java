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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode p=root;

        while(!st.isEmpty() || p!=null) {
            if(p!=null){
                res.add(p.val);
                st.push(p);
                p=p.left;
            } else {
                p=st.pop();
                p=p.right;
            }
        }

        return res;
    }
}

/* // similar approach for in order traversal
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            result.add(node.val);  // Add after all left children
            p = node.right;
        }
    }
    return result;
}
*/

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();

        if (root==null) return res;

        st.push(root);
        while(!st.isEmpty()){
            TreeNode n = st.pop();
            res.add(n.val);
            if (n.right!=null) st.push(n.right);
            if (n.left!=null) st.push(n.left);
        }

        return res;
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res){
        if (root==null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
