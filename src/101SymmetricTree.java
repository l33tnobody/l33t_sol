class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right; // check null
        if(left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

// using a single queue:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return true;
        
        q.add(root.left);
        q.add(root.right);
        while(q.size() > 0){
            TreeNode left = q.poll(), right = q.poll();
            if(left== null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);            
        }
        return true;
    }
}

// using two queues:
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty()) {
            TreeNode left = q1.poll(), right = q2.poll();
            if(left== null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            q1.add(left.left);
            q1.add(left.right);
            q2.add(right.right);
            q2.add(right.left);            
        }
        return true;
    }
}