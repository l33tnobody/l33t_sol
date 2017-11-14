/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, ArrayList<Integer>> m = new HashMap<>(); // map from col index to the array holding node values
        Queue<TreeNode> qnode = new LinkedList<>();
        Queue<Integer> qcol = new LinkedList<>();

        qnode.add(root);
        qcol.add(0);
        int min = 0, max = 0;

        while(!qnode.isEmpty()) {
            TreeNode n = qnode.poll();
            int col = qcol.poll();

            if(!m.containsKey(col)) {
                m.put(col, new ArrayList<>());
            }

            m.get(col).add(n.val);

            if (n.left != null) {
                qnode.add(n.left);
                qcol.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (n.right != null) {
                qnode.add(n.right);
                qcol.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for(int col=min; col<=max; col++) {
            res.add(m.get(col));
        }

        return res;
    }
}
