// mergesort and count
class Solution {
    public int reversePairs(int[] nums) {
        return reversePairsHelper(nums, 0, nums.length - 1);
    }

    private int reversePairsHelper(int[] nums, int l, int r) {
        if(l >= r) return 0;

        int m = l + (r - l) / 2;
        int res = reversePairsHelper(nums, l, m) + reversePairsHelper(nums, m + 1, r);

        int[] tmp = new int[r - l + 1];
        int j = m + 1, k = m + 1, p = 0;

        for(int i = l; i <= m; i++, p++) {
            while(j <= r && nums[i] > 2L*nums[j]) j++; // int might be overflow here
            res += j - (m + 1);

            while(k <= r && nums[i] > nums[k]) tmp[p++] = nums[k++];
            tmp[p] = nums[i];
        }

        for(int q = 0; q < p; q++) {
            nums[l + q] = tmp[q];
        }

        return res;
    }
}

// BST based see: https://discuss.leetcode.com/topic/79227/general-principles-behind-problems-similar-to-reverse-pairs
class Node {
    int val, cnt;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.cnt = 1;
    }
}

private int search(Node root, long val) {
    if (root == null) {
    	return 0;
    } else if (val == root.val) {
    	return root.cnt;
    } else if (val < root.val) {
    	return root.cnt + search(root.left, val);
    } else {
    	return search(root.right, val);
    }
}

private Node insert(Node root, int val) {
    if (root == null) {
        root = new Node(val);
    } else if (val == root.val) {
        root.cnt++;
    } else if (val < root.val) {
        root.left = insert(root.left, val);
    } else {
        root.cnt++;
        root.right = insert(root.right, val);
    }

    return root;
}

public int reversePairs(int[] nums) {
    int res = 0;
    Node root = null;

    for (int ele : nums) {
        res += search(root, 2L * ele + 1);
        root = insert(root, ele);
    }

    return res;
}
