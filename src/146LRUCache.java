public class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity, count;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>(capacity+1); // overflow one more, see set() method
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        node = new Node(key, value);
        map.put(key, node);
        putToHead(node);
        count++;

        if (count > capacity) {
            deleteTail();
            count--;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        putToHead(node);
    }

    private void putToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    private void deleteTail() {
        Node nodeTail = tail.pre;
        removeNode(nodeTail);
        map.remove(nodeTail.key);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}
