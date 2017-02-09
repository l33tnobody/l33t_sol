// trade off: faster add or faster find, pick the faster one that needs to be optimized.

// O(1) add, O(n) find
public class TwoSum {

    private List<Integer> nums = new ArrayList<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    nums.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    Set<Integer> s = new HashSet<>();

        for(int i=0; i<nums.size(); i++) {
            if (s.contains(nums.get(i))) {
                return true;
            }
            s.add(value - nums.get(i));
        }
        return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);


// O(n) add, O(1) find
public class TwoSum {

    private List<Integer> nums = new ArrayList<>();
    private Set<Integer> s = new HashSet<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    nums.add(number);
	    for (int i=0; i < nums.size()-1; i++) {
	        s.add(nums.get(i) + number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return s.contains(value);
	}
}
