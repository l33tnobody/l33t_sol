// better solution
public class Solution {
    public int rob(TreeNode root) {
        int[] res = robhelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robhelper(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robhelper(root.left);
        int[] right = robhelper(root.right);

        int[] res = new int[2];
        // not to rob root:
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // rob root:
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}


// overlapping subproblem optimized using a HashMap, not as good.
public class Solution {
    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }
}
