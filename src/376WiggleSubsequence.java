class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int up = 1, down = 1;
        for(int i=1; i<n; i++) {
            if(nums[i] > nums[i-1]) {
                up = down + 1;
            } else if (nums[i] < nums[i-1]) {
                down = up + 1;
            } // else up and down has no change.
        }

        return Math.max(up, down);
    }
}


// a greedy solution to get the actual wiggle sequence result
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, res = 0;
        if (n == 0) return 0;

        int first = 0, second = 1;
        while(second < n && nums[second] == nums[first]) second++;
        if (second == n) return 1;

        boolean asc = nums[second] > nums[first] ? true : false;
        res = 2;
        nums[res-1] = nums[second];
        first = res-1;
        second++;
        asc = !asc;

        while(second < n) {
            if(nums[second] > nums[first] && asc) {
                nums[res] = nums[second];
                first = res;
                res++;
                second++;
                asc = !asc;
            } else if (nums[second] < nums[first] && !asc) {
                nums[res] = nums[second];
                first = res;
                res++;
                second++;
                asc = !asc;
            } else { // nums[second] == nums[first], OR increase when want desc, OR decrease when want asc
                nums[first] = nums[second]; // or nums[res-1] = nums[second]
                // no change to res
                second++;
            }
        }

        return res; // nums[0 ~ res-1] are one wiggle result.
    }
}
