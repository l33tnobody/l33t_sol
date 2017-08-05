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
// using divide and conquer, time complexity O(nlogk), with n being the total number of nodes
 public class Solution {
     public ListNode mergeKLists(ListNode[] lists) {
         return helper(lists, 0, lists.length - 1);
     }

     private ListNode helper(ListNode[] lists, int s, int e) {
         if (s == e) {
             return lists[s];
         } else if (s < e) {
             int mid = (e - s)/2 + s;
             ListNode l = helper(lists, s, mid);
             ListNode r = helper(lists, mid+1, e);
             return mergeTwoLists(l, r);
         } else {
             return null;
         }
     }

     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(0);
         ListNode p = dummy;

         while(l1!=null && l2!=null) {
             if(l1.val < l2.val){
                 p.next = l1;
                 l1 = l1.next;
             } else {
                 p.next = l2;
                 l2 = l2.next;
             }
             p = p.next;
         }

         if(l1 == null){
             p.next=l2;
         } else {
             p.next=l1;
         }

         return dummy.next;
     }
 }

// using heap to pull smallest head: O(n*logk) + k(heap construction)
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if(n1.val < n2.val)   return -1;
                if(n1.val > n2.val)   return 1;
                return 0;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        for(ListNode ln : lists){
            if(ln != null) heap.add(ln);
        }

        while(!heap.isEmpty()) {
            p.next = heap.poll();
            p = p.next;

            if(p.next != null) heap.add(p.next);
        }

        return dummy.next;
    }
}

// w/o using dummy head
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
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
