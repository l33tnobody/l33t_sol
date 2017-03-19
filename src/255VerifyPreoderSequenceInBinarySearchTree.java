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
