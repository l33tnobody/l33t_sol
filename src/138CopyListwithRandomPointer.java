/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// O(n) additional space except from the result
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode ptr = head;
        while(ptr != null) { // make copy and find mapping
            RandomListNode copy = new RandomListNode(ptr.label);
            map.put(ptr, copy);
            ptr = ptr.next;
        }
        
        ptr = head;
        while(ptr != null) {
            RandomListNode copy = map.get(ptr);
            copy.next = map.get(ptr.next); // ptr.next == null ? null : map.get(ptr.next); 
            copy.random = map.get(ptr.random); // ptr.random == null ? null : map.get(ptr.random);
            ptr = ptr.next;
        }
        
        return map.get(head); // map.get(null) returns null
    }
}

// O(1) additional space except from the result
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode ptr = head;
        while(ptr != null) { // copy and make mappings
            RandomListNode copy = new RandomListNode(ptr.label);
            copy.next = ptr.next;
            ptr.next = copy;
            ptr = ptr.next.next;
        }
        
        //assign random pointer according to mapping
        ptr = head;
        while(ptr != null) {
            RandomListNode copy = ptr.next;
            copy.random = ptr.random == null ? null : ptr.random.next;
            ptr = ptr.next.next;
        }
        
        RandomListNode copyhead = head == null? null : head.next;
        ptr = head;
        while(ptr != null) {
            RandomListNode copy = ptr.next, next = copy.next;
            copy.next = next == null ? null : next.next;
            ptr.next = next;
            ptr = ptr.next;
        }
        
        return copyhead;
    }
}