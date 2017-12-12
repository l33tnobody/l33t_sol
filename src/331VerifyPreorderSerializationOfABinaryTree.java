class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        // indegree -, outdegree +, in the end the sum should be 0,
        // and the sum is non-negative at all time
        int diff = 1; // imagine root has indegree of 1

        for(String n : nodes) {
            diff--; // every node has 1 indegree
            if(diff < 0) return false;
            if(!n.equals("#")) diff += 2;
        }

        return diff == 0;
    }
}

// stack solution not very straightforward
// https://discuss.leetcode.com/topic/35973/java-intuitive-22ms-solution-with-stack
