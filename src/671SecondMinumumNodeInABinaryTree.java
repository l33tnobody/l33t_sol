// with pruning, better than going through all nodes
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        
        int l = root.left.val;
        int r = root.right.val;
        
        if(root.left.val == root.val) l = findSecondMinimumValue(root.left);
        if(root.right.val == root.val) r = findSecondMinimumValue(root.right);
        
        if(l == -1) return r;
        else if(r == -1) return l;
        else return Math.min(l, r);
    }
}

// original solution with global var
class Solution {
    int secondmin = Integer.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        recur(root);
        return secondmin == Integer.MAX_VALUE ? -1 : secondmin;
    }
    
    private void recur(TreeNode root) {
        if(root == null || root.left == null) return;
        
        if(root.left.val != root.right.val) {
            TreeNode bigger = root.left;
            if(bigger.val < root.right.val) bigger = root.right;
            
            secondmin = Math.min(secondmin, bigger.val);
            recur(bigger == root.left ? root.right : root.left);
        } else {
            recur(root.left);
            recur(root.right);
        }
    }
}