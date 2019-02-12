// back tracing is better than dp in this case where the question requires
// no duplicate combinations such as [1, 2], [2, 1]
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> running = new ArrayList<>();
        comboHelper(k, n, 1, running, res);
        return res;
    }

    private void comboHelper(int k, int sum, int curr, List<Integer> running, List<List<Integer>> res) {
        if (k==0 && sum==0) {
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for (int i=curr; i<=9; i++){
            if (sum<i || k<=0)
                break;

            running.add(i);
            comboHelper(k-1, sum-i, i+1, running, res);
            running.remove(running.size()-1);
        }
    }
}
