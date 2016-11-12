/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// recursive solution will stackoverflow on one test case
public class Solution {
    HashMap<Integer, RandomListNode> map = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        return clone(head);
    }

    private RandomListNode clone(RandomListNode node){
        if (node==null) return null;

        if (map.containsKey(node.label)) return map.get(node.label);

        RandomListNode copy = new RandomListNode(node.label);
        map.put(node.label, copy);

        copy.next = clone(node.next);
        copy.random = clone(node.random);

        return copy;
    }
}


// Iterative Solution
public class Solution {
    HashMap<Integer, RandomListNode> map = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head.label, newHead);

        LinkedList<RandomListNode> q = new LinkedList<>();
        q.add(head);

        while(!q.isEmpty()) {
            RandomListNode n = q.pop();
            RandomListNode ncopy = map.get(n.label);

            if (n.next != null && !map.containsKey(n.next.label)) {
                RandomListNode nextcopy = new RandomListNode(n.next.label);
                map.put(n.next.label, nextcopy);
                q.add(n.next);
            }
            ncopy.next = (n.next == null) ? null : map.get(n.next.label);

            // can extract to a common helper function
            if (n.random != null && !map.containsKey(n.random.label)){
                RandomListNode randomcopy = new RandomListNode(n.random.label);
                map.put(n.random.label, randomcopy);
                q.add(n.random);
            }
            ncopy.random = (n.random == null) ? null : map.get(n.random.label);
        }

        return newHead;
    }
}
