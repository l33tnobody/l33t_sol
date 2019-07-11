// similar to classic problem of recovering two swapped numbers in a sorted array
// find the first pair out of order first, assign to first and second
// then try to find the second pair if it exists (it might not exist if adjacent ones got swapped)
// keep bigger one in pair one, assign the smaller one in second pair to second
// swap the two
class Solution {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null;

    public void recoverTree(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        if (prevElement != null && prevElement.val > root.val) {
            if (firstElement == null) {
                firstElement = prevElement;
                secondElement = root;
            } else {
                secondElement = root;
                return; // can return here since prev is pointing to the smallest in order node.
            }
        }

        prevElement = root;

        traverse(root.right);
    }
}

// O(1) space requires Morris Traversal (shrug) just for fun for science