class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        root.val = 0; // the heap index, use val to store it or can use a map to store that
        int max = 1;
        
        while(!q.isEmpty()) {
            max = Math.max(max, q.peekLast().val - q.peekFirst().val + 1);
            for(int sz = q.size(); sz > 0; sz--) {
                TreeNode tn = q.poll();
                if(tn.left != null) {
                    tn.left.val = tn.val * 2;
                    q.offer(tn.left);
                }
                if(tn.right != null) {
                    tn.right.val = tn.val * 2 + 1;
                    q.offer(tn.right);
                }
            }
        }
        
        return max;
    }
}