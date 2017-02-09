public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int[] res = new int[2];
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
            map.put(target-nums[i], i);
        }

        //if not found
        int[] res_notfound = new int[2];
        res_notfound[0] = res_notfound[1] = -1;
        return res_notfound;
    }
}
