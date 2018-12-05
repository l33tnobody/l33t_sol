class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean forward = true;

        if(root == null) return res;

        q.offer(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i=0; i<sz; i++) {
                TreeNode tn = q.poll();
                if(forward) l.add(tn.val);
                else l.add(0, tn.val);
                if(tn.left != null) q.offer(tn.left);
                if(tn.right != null) q.offer(tn.right);
            }
            res.add(l);
            forward = !forward;
        }

        return res;
    }
}