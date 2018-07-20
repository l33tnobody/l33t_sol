class Solution {
    int sum = 0; // turn this into a int[1] to pass around to get rid of the global var
    
    public int findTilt(TreeNode root) { // return sum of the whole tree
        recurSumTilt(root);
        return sum;
    }
    
    private int recurSumTilt(TreeNode root) { //accumulate tilt and return sum of all nodes
        if(root == null) return 0;
        int l = recurSumTilt(root.left);
        int r = recurSumTilt(root.right);
        sum += Math.abs(l - r);
        return l + r + root.val;
    }
}