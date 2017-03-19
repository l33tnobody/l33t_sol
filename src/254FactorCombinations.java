public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> running, int n, int start) {
        if (n == 1) {
            if (running.size() > 1) res.add(new ArrayList<Integer>(running));
            return;
        }

        for (int i=start; i<=n; i++) {
            if (n % i !=0 ) continue;
            running.add(i);
            helper(res, running, n/i, i);
            running.remove(running.size()-1);
        }
    }
}

// an optimization
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> running, int n, int start) {
        if (n == 1) {
            if (running.size() > 1) res.add(new ArrayList<Integer>(running));
            return;
        }

        for (int i=start; i<=Math.floor(Math.sqrt(n)); i++) {
            if (n % i !=0 ) continue;
            running.add(i);
            helper(res, running, n/i, i);
            running.remove(running.size()-1);
        }

        running.add(n);
        helper(res, running, 1, n);
        running.remove(running.size()-1);
    }
}
