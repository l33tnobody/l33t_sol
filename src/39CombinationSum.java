public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        Arrays.sort(candidates);
        comboHelper(candidates, target, 0, running, res);
        return res;
    }

    private void comboHelper(int[] candidates, int target, int pos, List<Integer> running, List<List<Integer>> res) {
        if (target==0) {
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for(int i=pos; i<candidates.length; i++) {
            if (target < candidates[i])
                break;

            if (i>pos && candidates[i] == candidates[i-1]) //remove dup
                continue;

            running.add(candidates[i]);
            comboHelper(candidates, target-candidates[i], i, running, res);
            running.remove(running.size()-1);
        }
    }
}