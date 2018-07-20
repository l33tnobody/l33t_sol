class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> lv = new LinkedList<>();
        lv.offer(root);
        
        while(!lv.isEmpty()) {
            int sz = lv.size();
            long sum = 0;
            
            for(int size = lv.size(); size > 0; size--) {
                TreeNode tn = lv.poll();
                sum += tn.val;
                if(tn.left != null) lv.offer(tn.left);
                if(tn.right != null) lv.offer(tn.right);
            }
            res.add(sum * 1.0 / sz);
        }
        return res;
    }
}