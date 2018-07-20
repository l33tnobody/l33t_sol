class Solution {
    List<Integer> nodes = new ArrayList<>();
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return nodes;
        
        nodes.add(root.val); // part of left bound for sure
        leftBoundary(root.left);
        leaves(root.left);  // devide root.left and right to avoid a single node added twice
        leaves(root.right);
        rightBoundary(root.right);
        
        return nodes;
    }
    
    public void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) leftBoundary(root.right);
        else leftBoundary(root.left);
    }
    
    public void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
    
    public void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null) rightBoundary(root.left);
        else rightBoundary(root.right);
        nodes.add(root.val); // add after child visit(reverse)
    }
}