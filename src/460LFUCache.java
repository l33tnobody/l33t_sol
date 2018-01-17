// linkedhashset is: Hash table and linked list implementation of the Set interface,
// with predictable iteration order.
// This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries.
// This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order).

class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts; // frequency boils down to counts of each val since the sum is the same
    HashMap<Integer, LinkedHashSet<Integer>> lists; // from count to a hashset of keys, linkedhashset has add/remove O(1) and iteration order same as the insertion order (O1 to remove the least recently used if there is a tie)
    int cap;
    int min = -1; // track the min count

    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key)) return -1;

        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(min == count && lists.get(count).size() == 0) min++;

        if(!lists.containsKey(count+1)) lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);

        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap <= 0) return; // to guarantee 0 capacity and program not crashing

        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key); // update frequency
            return;
        }

        if(vals.size() >= cap) {
            int evict = lists.get(min).iterator().next(); // the least recently used and min frequency one
            lists.get(min).remove(evict);
            counts.remove(evict); // no keep of frequency of removed key
            vals.remove(evict);
        }

        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
