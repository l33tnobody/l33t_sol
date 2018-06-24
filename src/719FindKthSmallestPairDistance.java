// AC: O(n^2logmaxdiff)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        // Minimum absolute difference
        int low = nums[1] - nums[0];
        for (int i = 1; i < n - 1; i++) low = Math.min(low, nums[i + 1] - nums[i]);
        // Maximum absolute difference
        int high = nums[n - 1] - nums[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(count(mid, nums) < k) low = mid + 1;
            else high = mid;
        }

        return high;
    }

    private int count(int diff, int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while(j < nums.length && nums[j] - nums[i] <= diff) j++;
            res += j - i - 1;
        }
        return res;
    }
/* count function can further be optimized to nlogn instead of n^2, so the total time complexity becomes: nlognlogmaxdiff
    private int count(int diff, int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int j = higherKey(nums, i, nums.length - 1, nums[i] + diff);
            res += j - i - 1; // a[j] - a[i] > diff : j is the least key, so j - i - 1 means number of the pairs that have a[j] - a[i] <= diff
        }
        return res;
    }

    // find the index of the higher key: the least key that has its value stricly greater than key.
    private int higherKey(int[] nums, int l, int h, int key) {
        if(nums[h] <= key) return h + 1; // imaginary higher key, have to have this line here otherwise will return h
        while(l < h) {
            int m = l + (h - l) / 2;
            if(nums[m] <= key) l = m+1;
            else h = m;
        }
        return h;
    }
*/
}

// TLE for one test case but works. O(nlogn + klogn) so up to n^2logn
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>(n, (a, b) -> (a.diff - b.diff));
        for(int i = 1; i < n; i++) {
            pq.offer(new Tuple(i, i-1, nums[i] - nums[i-1]));
        }

        for(int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if(t.y == 0) continue;
            pq.offer(new Tuple(t.x, t.y - 1, nums[t.x] - nums[t.y - 1]));
        }

        return pq.peek().diff;
    }

    class Tuple {
        int x, y, diff;
        public Tuple(int x, int y, int diff) {
            this.x = x; // x will be larger than y for indexes
            this.y = y;
            this.diff = diff;
        }
    }
}
