/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> st;

    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        for(int i=nestedList.size()-1; i>=0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() { // make sure this is always a Integer if hasNext()
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!st.isEmpty()) {
            NestedInteger t = st.peek();
            if (t.isInteger()) return true;
            // else flatten the list
            st.pop();
            List<NestedInteger> tlist = t.getList();
            for(int i=tlist.size()-1; i>=0; i--) { // this will remove any empty list as well
                st.push(tlist.get(i));
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
