public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(res, "", num, 0, target, 0, 0);
        return res;
    }

    private void helper(List<String> res, String path, String num, int pos, int target, long cur, long prev) {
        if (pos == num.length()) {
            if (target == cur) {
                res.add(path);
            }
            return;
        }

        for(int i=pos; i<num.length(); i++) {
            // cannot start with 0
            if (num.charAt(pos)=='0' && i!=pos) break;

            Long val = Long.parseLong(num.substring(pos, i+1));
            if (pos==0) {
                helper(res, path+val, num, i+1, target, val, val);
            } else {
                helper(res, path+"+"+val, num, i+1, target, cur+val, val);
                helper(res, path+"-"+val, num, i+1, target, cur-val, -val);
                helper(res, path+"*"+val, num, i+1, target, cur-prev+prev*val, prev*val);
            }
        }
    }
}
