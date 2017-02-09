public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int w = 0; w < nums.length - 3; w++) {
            if(w > 0 && nums[w] == nums[w-1]) continue;

            for(int x = w + 1; x < nums.length-2; x++) {
                if (x > w + 1 && nums[x] == nums[x-1]) continue;
                int y = x + 1;
                int z = nums.length-1;

                while(y < z) {
                    int sum = nums[w] + nums[x] + nums[y] + nums[z];

                    if (sum < target) {
                        y++;
                    } else if (sum > target) {
                        z--;
                    } else {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[w]);
                        l.add(nums[x]);
                        l.add(nums[y]);
                        l.add(nums[z]);
                        res.add(l);
                        do{ y++; } while(y < z && nums[y] == nums[y - 1]);
                        do{ z--; } while(y < z && nums[z] == nums[z + 1]);
                    }
                }
            }
        }

        return res;
    }
}
