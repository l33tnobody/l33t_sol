class RandomizedCollection {
    ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs;
	java.util.Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
	    locs = new HashMap<>();
        rand = new java.util.Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) locs.put(val, new LinkedHashSet<Integer>());
        locs.get(val).add(nums.size());
        nums.add(val);
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
	    if (!contain) return false;

	    int loc = locs.get(val).iterator().next(); // for linkedhashmap the next() call will be constant
        locs.get(val).remove(loc); // this line has to be here but not after, because the last num might be same the val and then removing loc later might cause extra removal of the same val element.
	    if (locs.get(val).isEmpty()) locs.remove(val);
	    if (loc < nums.size() - 1) {
	       int lastone = nums.get(nums.size()-1);
	       nums.set(loc, lastone);
	       locs.get(lastone).remove(nums.size()-1);
	       locs.get(lastone).add(loc);
	    }
	    nums.remove(nums.size()-1);
	    return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

// a much better way but hard to think of:
// There are two data member in the solution
//
// a vector nums
// an unordered_map m
// The key of m is the val, the value of m is a vector contains indices where the val appears in nums.
// Each element of nums is a pair, the first element of the pair is val itself, the second element of the pair is an index into m[val].
// There is a relationship between nums and m:
//
// m[nums[i].first][nums[i].second] == i;
//

class RandomizedCollection {
public:
    /** Initialize your data structure here. */
    RandomizedCollection() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    bool insert(int val) {
        auto result = m.find(val) == m.end();

        m[val].push_back(nums.size());
        nums.push_back(pair<int, int>(val, m[val].size() - 1));

        return result;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    bool remove(int val) {
        auto result = m.find(val) != m.end();
        if(result)
        {
            auto last = nums.back();
            m[last.first][last.second] = m[val].back();
            nums[m[val].back()] = last;
            m[val].pop_back();
            if(m[val].empty()) m.erase(val);
            nums.pop_back();
        }
        return result;
    }

    /** Get a random element from the collection. */
    int getRandom() {
        return nums[rand() % nums.size()].first;
    }
private:
    vector<pair<int, int>> nums;
    unordered_map<int, vector<int>> m;
};

// a rewrite in Java
class RandomizedCollection {
    ArrayList<int[]> nums; // each int[] is a pair of val, and the index of map's arraylist
    Map<Integer, ArrayList<Integer>> map; // val maps to the indexes of nums
    java.util.Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new java.util.Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        if(!contain) map.put(val, new ArrayList<>());
        map.get(val).add(nums.size());
        nums.add(new int[]{val, map.get(val).size() - 1});
        return !contain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int lastindex = map.get(val).size() - 1;
        int loc = map.get(val).get(lastindex);
        int[] last = nums.get(nums.size() - 1);
        map.get(last[0]).set(last[1], loc);
        nums.set(loc, last);
        nums.remove(nums.size() - 1);
        map.get(val).remove(lastindex);
        if (map.get(val).isEmpty()) map.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()))[0];
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
