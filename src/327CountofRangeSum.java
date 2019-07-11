// just for fun:
// merge sort on presum and count range sum within lower and upper
// (the difference of presum is range sum)
// nlogn time

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        return countWhileMergeSort(sums, 0, n, lower, upper);
    }

    // recursive:
    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if(end <= start) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) +
                    countWhileMergeSort(sums, mid + 1, end, lower, upper);

        int j = mid + 1, k = mid + 1, t = mid + 1;
        long[] tmp = new long[end - start + 1];
        int r = 0;
        for (int i=start; i<=mid; i++, r++) {
            while(j <= end && sums[j] - sums[i] < lower) j++;
            while(k <= end && sums[k] - sums[i] <= upper) k++;
            while(t <= end && sums[t] < sums[i]) tmp[r++] = sums[t++]; // merge sort

            count += k-j;
            tmp[r] = sums[i];
        }

        for(int it = 0; it < r; it++) {
            sums[start+it] = tmp[it];
        }

        return count;
    }
}