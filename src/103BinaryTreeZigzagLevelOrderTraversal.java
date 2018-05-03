class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        boolean forward = true;

        if(root == null) return res;

        q.offer(root);
        while(!q.isEmpty()) {
            Deque<TreeNode> newq = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()) {
                TreeNode tn = q.poll();
                if(forward) list.add(tn.val);
                else list.add(0, tn.val);
                if(tn.left != null) newq.offer(tn.left);
                if(tn.right != null) newq.offer(tn.right);
            }
            res.add(list);
            q = newq;
            forward = !forward;
        }
        return res;
    }
}
