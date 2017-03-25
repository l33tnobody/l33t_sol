public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Integer[] newnums = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++) newnums[i] = nums[i];

        permute(0, newnums, res);
        return res;
    }

    private void permute(int s, Integer[] running, List<List<Integer>> res) {
        if (s == running.length - 1) {
            // Arrays.asList returns an array backed list that regflect changes to the array itself, so need to create a clone here.
            res.add(new ArrayList<Integer>(Arrays.asList(running)));
            return;
        }

        Set<Integer> set = new HashSet<>();     // remove duplicate
        for(int i=s; i<running.length; i++) {
            if (set.contains(running[i])) continue;
            set.add(running[i]);
            swap(running, s, i);
            permute(s+1, running, res);
            swap(running, s, i);
        }
    }

    private void swap(Integer[] nums, int i, int j) {
        if(i==j) return;

        Integer temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
