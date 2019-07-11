// Boundry count:
// the key is to use a BST keyed on time, add and remove event, in order traversal would be
// the same as traversal ascendingly based on time. this can help save some time from insert of O(n) to O(logn)

// This is to find the maximum number of concurrent ongoing event at any time.
// We can log the start & end of each event on the timeline, each start add a new ongoing event at that time, each end terminate an ongoing event. Then we can scan the timeline to figure out the maximum number of ongoing event at any time.
// The most intuitive data structure for timeline would be array, but the time spot we have could be very sparse, so we can use sorted map to simulate the timeline to save space.
// O(n)
class MyCalendarThree {
    private Map<Integer, Integer> timeline; // from timepoint to how many events

    public MyCalendarThree() {
        timeline = new TreeMap<>(); // Balanced BST
    }

    public int book(int start, int end) {
        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
        int ongoing = 0, k = 0;
        for(int v : timeline.values()) { // iterate in the order of keys which means time
            ongoing += v;
            k = Math.max(k, ongoing);
        }
        return k;
    }
}

// O(n)
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */

// if need to self implement a BST:
class MyCalendarThree {
    class Node{
        private int k, v;
        private Node left, right;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    private Node root;
    private int curt, count;

    public MyCalendarThree() {

    }

    private Node insert(Node node, int k, int v) {
        if (node == null) {
            node = new Node(k, v);
            return node;
        } else if (node.k == k) {
            node.v += v;
        } else if (node.k < k) {
            node.right = insert(node.right, k, v);
        } else {
            node.left = insert(node.left, k, v);
        }
        return node;
    }

    private void count(Node node) { // in order traversal of keys which means time
        if (node == null) {
            return;
        }
        count(node.left);
        curt += node.v;
        count = Math.max(count, curt);
        count(node.right);
    }

    public int book(int start, int end) {
        root = insert(root, start, 1);
        root = insert(root, end, -1);
        curt = count = 0;
        count(root);
        return count;
    }
}


// segment tree: O(logn + log(len)) just for fun
// booked is actually lazy eval, not required. Just get the max of left and right,
// it is a max segment tree
class SegmentTreeNode{
    int start;
    int end;
    int booked;
    int saved;
    SegmentTreeNode left;
    SegmentTreeNode right;
    public SegmentTreeNode(int start, int end, int booked, int saved){
        this.start = start;
        this.end = end;
        this.booked = booked; // wholly covered
        this.saved = saved; // max at this node
    }
}

private SegmentTreeNode root;

private void addValue(int start, int end, int val, SegmentTreeNode node){
    // if(start > node.end || end < node.start) return;

    if(start <= node.start && node.end <= end){
        node.booked += val;
        node.saved += val;
        return;
    }
    int mid = node.start + (node.end - node.start) / 2;
    if(start <= mid){
        if(node.left == null) node.left = new SegmentTreeNode(node.start, mid, 0, 0);
        addValue(start, Math.min(mid, end), val, node.left);
    }
    if(end >= mid + 1){
        if(node.right == null) node.right = new SegmentTreeNode(mid + 1, node.end, 0, 0);
        addValue(Math.max(mid + 1, start), end, val, node.right);
    }
    // this max = whole covered + max(left , right)
    node.saved = Math.max(node.left == null ? 0 : node.left.saved,
                          node.right == null ? 0 : node.right.saved) + node.booked;
}

public MyCalendarThree() {
    root = new SegmentTreeNode(0, 1000000000, 0, 0);
}

public int book(int start, int end) {
    addValue(start, end - 1, 1, root);
    return root.saved;
}
