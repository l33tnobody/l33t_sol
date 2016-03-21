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
    private static final String nah="null";
    private static final String delimeter=",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode tr, StringBuilder sb){
        if (tr==null){
            sb.append(nah).append(delimeter);
        } else { // preorder recursion
            sb.append(tr.val).append(delimeter);
            buildString(tr.left, sb);
            buildString(tr.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(delimeter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(List<String> nodes) {
        String cur = nodes.remove(0);
        if (cur.equals(nah)) return null;
        else {
            TreeNode root = new TreeNode(Integer.valueOf(cur));
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
