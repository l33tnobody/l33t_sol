// preorder, select smaller ones for left child
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);
        return sb.toString();
    }

    private void shelper(TreeNode root, StringBuilder sb) {
        if(root==null) return;
        sb.append(root.val).append(",");
        shelper(root.left, sb);
        shelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        List<Integer> nodelist = new LinkedList<>();
        String[] sa = data.split(",");
        for(String s : sa) {
            nodelist.add(Integer.valueOf(s));
        }
        return constructTree(nodelist);
    }

    private TreeNode constructTree(List<Integer> nodelist) {
        if (nodelist.size() == 0) return null;

        int cur = nodelist.remove(0);
        TreeNode root = new TreeNode(cur);
        List<Integer> smallerlist = new LinkedList<>();
        while(nodelist.size() != 0 && nodelist.get(0).intValue() < cur) {
            smallerlist.add(nodelist.remove(0));
        }

        root.left = constructTree(smallerlist);
        root.right = constructTree(nodelist);
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);
        return sb.toString();
    }

    private void shelper(TreeNode root, StringBuilder sb) {
        if(root==null) return;
        sb.append(root.val).append(",");
        shelper(root.left, sb);
        shelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        List<Integer> nodelist = new LinkedList<>();
        String[] sa = data.split(",");
        for(String s : sa) {
            nodelist.add(Integer.valueOf(s));
        }
        return constructTree(nodelist, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructTree(List<Integer> nodelist, Integer lower, Integer upper) {
        if (nodelist.size() == 0) return null;

        Integer cur = nodelist.get(0);
        if (cur.intValue() < lower.intValue() || cur.intValue() > upper.intValue()) return null;

        TreeNode root = new TreeNode(cur);
        nodelist.remove(0);
        root.left = constructTree(nodelist, lower, cur);
        root.right = constructTree(nodelist, cur, upper);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
