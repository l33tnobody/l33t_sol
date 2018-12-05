// up to O(n) space for stack
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for (int cur : preorder) {
            if (cur < low) return false;

            while(!st.isEmpty() && cur > st.peek()) {
                low = st.pop();
            }

            st.push(cur);
        }

        return true;
    }
}

// recursive solution:
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private boolean helper(int[] preorder, int s, int e) {
        if(s >= e) return true;

        int root = preorder[s];
        int r = s+1;
        while(r<=e && preorder[r] < root) r++;

        for(int j=r; j<=e; j++) {
            if(preorder[j] < root) return false;
        }

        return helper(preorder, s+1, r-1) && helper(preorder, r, e);
    }
}


// nvm for this solution
// using the input as the stack, similar to above
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int i = -1;
        Stack<Integer> st = new Stack<>();

        for (int cur : preorder) {
            if (cur < low) return false;

            while(i>=0 && cur > preorder[i]) {
                low = preorder[i--];
            }

            preorder[++i] = cur;
        }

        return true;
    }
}
