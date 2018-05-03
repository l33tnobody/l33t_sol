class Solution { // greedy
    public int jump(int[] nums) {
        int steps = 0;
        int maxnext = 0; // the furthest we can reach currently
        int cur = 0; // the furtheset we have covered

        for(int i = 0; i < nums.length; i++){
            if(i > cur) {
                if(i > maxnext) return Integer.MAX_VALUE; // cannot reach here
                cur = maxnext;
                steps++;
            }
            maxnext = Math.max(maxnext, i+nums[i]);
        }

        return steps;
    }
}
