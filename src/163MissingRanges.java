public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;

        // short cut: note empty array
        if(nums.length==0 || lower>nums[nums.length-1] || upper<nums[0]){
            res.add(getRange(lower, upper));
            return res;
        }
                                    // note this
        for(int i=0; i<nums.length && next<=upper; i++) {
            if(nums[i]<next) continue;

            if(nums[i]==next) {
                next++;
                continue;
            }
            // num[i] > next
            int h = Math.min(nums[i]-1, upper); // note this
            res.add(getRange(next, h));
            next = h + 2;
        }
        if (next<=upper) res.add(getRange(next, upper));

        return res;
    }

    private String getRange(int l, int h) {
        if (l==h) return String.valueOf(l);

        return String.valueOf(l) + "->" + String.valueOf(h); //String.format("%d->%d", l, h);
    }
}
