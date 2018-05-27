class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(k == 0) {
                if(entry.getValue() >= 2) count++;
            } else {
                if(map.containsKey(entry.getKey() + k)) count++;
            }
        }

        return count;
    }
}


// an O(nlogn) solution just for fun:
public int findPairs(int[] nums, int k) {
    int ans = 0;
    Arrays.sort(nums); //O(nlogn)
    for (int i = 0, j = 0; i < nums.length; i++) {
        // O(n) amortized totally: j will not decrease
        for (j = Math.max(j, i + 1); j < nums.length && (long) nums[j] - nums[i] < k; j++) ;
        if (j < nums.length && (long) nums[j] - nums[i] == k) ans++;
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
    }
    return ans;
}
