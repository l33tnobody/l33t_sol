// for delete: the key is to swap the element to be deleted with the last one.

class RandomizedSet {
    ArrayList<Integer> nums; // to random
    HashMap<Integer, Integer> locs; // from the integer to the location
    java.util.Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new java.util.Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if(contain) return false; // already contains the val
        locs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if(!contain) return false;
        int loc = locs.get(val);
        if(loc < nums.size() - 1) { // if not the last the switch with the last element
            int last = nums.get(nums.size()-1);
            nums.set(loc, last);
            locs.put(last, loc);
        }
        nums.remove(nums.size() - 1);
        locs.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size())); // nextInt(n) gives uniformly random 0 ~ n-1
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
