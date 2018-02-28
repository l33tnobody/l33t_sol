class AllOne {
    // need to find a way to maintain min and max keys while maintaining order
    // can use a doublely linked list to track min and max and order on the value
    //   and to make the updating values in O(1) using a hashmap to store from value to the list node

    private class Bucket {
        int val;
        Set<String> keySet;
        Bucket next;
        Bucket pre;
        public Bucket(int value) {
            val = value;
            keySet = new LinkedHashSet<>(); // to have O(1) iterator().next() runtime
        }
    }

    private Bucket head;
    private Bucket tail;
    private Map<String, Integer> keyValMap;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> valBucketMap;


    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        valBucketMap = new HashMap<>();
        keyValMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (keyValMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyValMap.put(key, 1);
            if (head.next.val != 1) addBucketAfter(new Bucket(1), head);
            head.next.keySet.add(key);
            valBucketMap.put(1, head.next);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!keyValMap.containsKey(key)) return;

        int val = keyValMap.get(key);
        if (val == 1) {
            keyValMap.remove(key);
            removeKeyFromBucket(valBucketMap.get(val), key);
        } else {
            changeKey(key, -1);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keySet.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void changeKey(String key, int offset) {
        int val = keyValMap.get(key);

        keyValMap.put(key, val + offset);
        Bucket curBucket = valBucketMap.get(val);
        Bucket newBucket;
        if (valBucketMap.containsKey(val + offset)) {
            newBucket = valBucketMap.get(val + offset);
        } else {
            // add new Bucket
            newBucket = new Bucket(val + offset);
            valBucketMap.put(val + offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.pre);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            valBucketMap.remove(bucket.val);
        }
    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.pre.next = bucket.next;
        bucket.next.pre = bucket.pre;
        bucket.next = null;
        bucket.pre = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.pre = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
