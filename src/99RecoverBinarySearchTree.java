// can in order flatten all the treenodes into a linkedlist and go through
// the list again to find the misplaced two nodes.
// a just in-order traversal solution:
class Solution {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        
        // In order traversal to find the two elements
        traverse(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null) return;
            
        traverse(root.left);
        
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
    
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        traverse(root.right);
    }
}

// O(1) space requires Morris Traversal (shrug) just for fun for science