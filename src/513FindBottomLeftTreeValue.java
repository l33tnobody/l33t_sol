// Asking to get the leftmost value in the last row of the tree.
// just record the first (leftmost) element of each level

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode first = null;
        
        while (!q.isEmpty()) {
            first = q.peek(); // record the first node in each level
            for (int sz = q.size(); sz > 0; sz--) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        
        return first.val;
    }
}