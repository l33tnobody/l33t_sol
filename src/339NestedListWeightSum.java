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
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nl, int d) {
        int sum = 0;
        for(NestedInteger ni : nl) {
            if (ni.isInteger()) {
                sum += ni.getInteger() * d;
            } else {
                sum += helper(ni.getList(), d + 1);
            }
        }
        return sum;
    }
}

// iterative solution here: use a queue/multiple new queues
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int level = 1, sum = 0;

        while(!nestedList.isEmpty()) {
            int count = nestedList.size(); // or create a new queue everytime
            while(count>0) {
                NestedInteger ni = nestedList.remove(0);
                count--;
                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    nestedList.addAll(ni.getList());
                }
            }
            level++;
        }

        return sum;
    }
}
