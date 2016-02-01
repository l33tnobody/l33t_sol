public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root==null)
            return res;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node=queue.remove();
                if(i==size-1)
                    res.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }

        return res;
    }
}
