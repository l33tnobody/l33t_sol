public class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while(root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target))
                closest = root.val;
                
            if (target < root.val) root = root.left;
            else root = root.right;
        }

        return closest;
    }
}

public class Solution {
    private int closest;

    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        findval(root, target);
        return closest;
    }

    private void findval(TreeNode root, double t) {
        if (root == null) return;

        double v = (double) root.val;

        if ( Math.abs(v - t) < Math.abs((double)closest - t) ) closest = root.val;

        if (t == v) return;

        if (t < v) findval(root.left, t);
        else findval(root.right, t);
    }
}
