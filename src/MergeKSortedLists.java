/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists==null||lists.isEmpty()) return null;
        
        Comparator<ListNode> ct=new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                if(n1.val<n2.val)   return -1;
                if(n1.val>n2.val)   return 1;
                return 0;
            }
        };
        
        PriorityQueue<ListNode> heap=new PriorityQueue<ListNode>(lists.size(), ct);
        ListNode head=null;
        ListNode cur=null;
        
        for(ListNode ln : lists){
            if(ln!=null) heap.add(ln);
        }
        
        while(!heap.isEmpty()){
            if(head==null){
                head=heap.poll();
                cur=head;
            }else{
                cur.next=heap.poll();
                cur=cur.next;
            }
            if(cur.next!=null) heap.add(cur.next);
        }
        
        return head;
    }
}
