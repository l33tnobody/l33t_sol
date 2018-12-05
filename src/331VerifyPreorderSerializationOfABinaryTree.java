// in and out degree, sum >=0, at the end sum = 0

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        // indegree -, outdegree +, in the end the sum should be 0,
        // and the sum is non-negative at all time in preorder
        int diff = 1;

        for(String n : nodes) {
            diff--; // every node has 1 indegree
            if(diff < 0) return false;
            if(!n.equals("#")) diff += 2;
        }

        return diff == 0;
    }
}
