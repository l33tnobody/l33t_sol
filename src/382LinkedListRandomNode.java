// Reservoir Sampling:
// https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
// https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain

// Choose k entries from n numbers. Make sure each number is selected with the probability of k/n
// (special case: k=1)
// Choose 1, 2, 3, ..., k first and put them into the reservoir.
// For k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
// For k+i, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
// Repeat until k+i reaches n

class Solution {
    ListNode myhead;
    Random rand;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        myhead = head;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = myhead;
        int res = cur.val;
        
        for(int i = 1; cur.next != null; i++) {
            cur = cur.next;
            if(rand.nextInt(i + 1) == 0) { // use nextInt to get 1/n
                res = cur.val;             // replace at 1 / (1 + i) odd
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */