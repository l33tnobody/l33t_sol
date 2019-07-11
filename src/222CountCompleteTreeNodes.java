// O(logn*logn)
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int hl = height(root.left);
        int hr = height(root.right);

        if (hl == hr) return (1 << hl) + countNodes(root.right);
        else return (1 << hr) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        int h = 0;
        while(root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}



// equivalent iterative solution
public class Solution {
    public int countNodes(TreeNode root) {
        int count=0;
        while(root != null) {
            int hl = height(root.left);
            int hr = height(root.right);
            if (hl == hr) {
                count += (1 << hl);
                root = root.right;
            } else {
                count += (1 << hr);
                root = root.left;
            }
        }
        return count;
    }

    private int height(TreeNode root) {
        int h = 0;
        while(root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}

// a slightly more optimized iterative solution: see comment
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int hl = height(root.left); // save one height computation for each root
        int count = 0;
        while(root != null) {
            int hr = height(root.right);
            if (hl == hr) {
                count += (1 << hl);
                root = root.right;
            } else {
                count += (1 << hr);
                root = root.left;
            }
            hl--;
        }
        return count;
    }

    private int height(TreeNode root) {
        int h = 0;
        while(root != null) {
            h++;
            root = root.left;
        }
        return h;
    }
}
