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
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1, res = 0;

        while (i < nums.length - 1 && j < nums.length) {
            if (i >= j)
                j = i + 1;

            if ((long) nums[j] - nums[i] < k) {
                j++;
            } else if ((long) nums[j] - nums[i] > k) {
                i++;
            } else {
                res++;
                i++;
                while (i < nums.length - 1 && nums[i] == nums[i - 1])
                    i++;
            }
        }

        return res;
    }
}