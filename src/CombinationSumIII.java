//bad
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        comboHelper(k, 0, n, 1, new ArrayList<Integer>(), res);
        return res;
    }

    private void comboHelper(int k, int sum, int n, int curr, ArrayList<Integer> running, List<List<Integer>> res){
        for (int i=curr;i<=9;i++){
            sum+=i;
            running.add(i);

            if(sum==n && running.size()==k){
                res.add(new ArrayList<Integer>(running));
                running.remove(running.size()-1);
                sum-=i;
                break;
            } else if (sum<n && running.size()<k){
                comboHelper(k, sum, n, i+1, running, res); // pick i
                running.remove(running.size()-1);
                sum-=i;
                continue; // do not pick i
            } else if (sum<n && running.size()==k){
                sum-=i;
                running.remove(running.size()-1);
                continue;
            } else { //sum is too big
                sum-=i;
                running.remove(running.size()-1);
                break;
            }
        }
    }
}

//good:

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> running = new ArrayList<Integer>();
        comboHelper(k, n, 1, running, res);
        return res;
    }

    private void comboHelper(int k, int sum, int curr, ArrayList<Integer> running, List<List<Integer>> res){
        if (k==0 && sum==0) {
            res.add(new ArrayList<Integer>(running));
            return;
        }

        for (int i=curr;i<=9;i++){
            if (sum<i || k<0)
                break;

            running.add(i);
            comboHelper(k-1, sum-i, i+1, running, res);
            running.remove(running.size()-1);
        }
    }
}
