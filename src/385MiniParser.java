public class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') // is a single integer
            return new NestedInteger(Integer.valueOf(s));

        Stack<NestedInteger> st = new Stack<>();
        NestedInteger curr = null;
        int l=0;

        for(int r=0; r<s.length(); r++) {
            if (s.charAt(r) == '[') {
                if (curr != null) {
                    st.push(curr);
                }
                curr = new NestedInteger(); // create a new nested list
                l=r+1;
            } else if (s.charAt(r) == ']') {
                String num = s.substring(l, r);
                if (!num.isEmpty()) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                if (!st.isEmpty()) {
                    NestedInteger top = st.pop();
                    top.add(curr);
                    curr = top;
                }
                l=r+1;
            } else if (s.charAt(r) == ',') {
                if (s.charAt(r-1) != ']') { // number
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
                l=r+1;
            }
        }

        return curr;
    }
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
