public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new LinkedList<>();
        helper(list, root, target, k);
        return list;
    }

    private boolean helper(List<Integer> list, TreeNode root, double target, int k) {
        if (root == null) return false;

        if (helper(list, root.left, target, k)) return true;

        if (list.size() == k) {
            // the first one is always the smallest one
            if (Math.abs(list.get(0) - target) < Math.abs(root.val - target)) return true;
            else list.remove(0);
        }

        list.add(root.val);
        return helper(list, root.right, target, k);
    }
}

// k(log(n)) approach
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList<Integer>();
        Stack<TreeNode> pred = new Stack<TreeNode>();
        Stack<TreeNode> succ = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null) {
            if (target < curr.val) {
                succ.push(curr);
                curr = curr.left;
            } else {
                pred.push(curr);
                curr = curr.right;
            }
        }

        while (k > 0) {
            if (pred.empty() && succ.empty()) {
                break;
            } else if (pred.empty()) {
                result.add(getSuccessor(succ));
            } else if (succ.empty()) {
                result.add(getPredecessor(pred));
            } else if (Math.abs(target - pred.peek().val) < Math.abs(target - succ.peek().val)) {
                result.add(getPredecessor(pred));
            } else {
                result.add(getSuccessor(succ));
            }
            k--;
        }

        return result;
    }

    private int getPredecessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.left;
        while (p != null) {
            st.push(p);
            p = p.right;
        }
        return popped.val;
    }

    private int getSuccessor(Stack<TreeNode> st) {
        TreeNode popped = st.pop();
        TreeNode p = popped.right;
        while(p != null) {
            st.push(p);
            p = p.left;
        }
        return popped.val;
    }

}
