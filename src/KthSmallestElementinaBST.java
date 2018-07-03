// follow up question: store total count or left count in the treenode:
//     https://leetcode.com/discuss/43464/what-if-you-could-modify-the-bst-nodes-structure
// If we could add a count field in the BST node class, 
// it will take O(n) time when we calculate the count value for the whole tree, 
// but after that, it will take O(logn) time when insert/delete a node or calculate the kth smallest element.
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
        return kthSmallest(rootWithCount, k);
    }

    // O(n) time and O(logn) space (callstack or the tree depth) to rebuild the new tree
    private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
        if (root == null) return null;
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = buildTreeWithCount(root.left);
        rootWithCount.right = buildTreeWithCount(root.right);
        if (rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
        if (rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
        return rootWithCount;
    }

    // this one can be iterative by changing root and k
    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) return -1;
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
            if (rootWithCount.left.count == k-1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1-rootWithCount.left.count);
        } else {
            if (k == 1) return rootWithCount.val;
            return kthSmallest(rootWithCount.right, k-1);
        }
    }

    class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {val = x; count = 1;};
    }
}



// In order traversal: recursive
public class Solution {
    private int count = 0;
    private int result = Integer.MIN_VALUE;

    private boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null || found == true)
            return;
        traverse(root.left, k);
        count ++;
        if(count == k) {
            result = root.val;
            found = true;
        }
        traverse(root.right, k);
    }
}
    //interative: using a stack to do in-order-traversal
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;

        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);  // Just like recursion
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val;
                p = node.right;
            }
        }

        return Integer.MIN_VALUE;
    }
}


// BST: could count duplicate number of times of same nodes
public int kthSmallest(TreeNode root, int k) {
    int count = countNodes(root.left);

    if (k <= count) {
      return kthSmallest(root.left, k);
    } else if (k == count + 1){
      return root.val;
    }
    // k>count+1
    return kthSmallest(root.right, k-count-1);
}

public int countNodes(TreeNode n) {
    if (n == null)
        return 0;
    return 1 + countNodes(n.left) + countNodes(n.right);
}
