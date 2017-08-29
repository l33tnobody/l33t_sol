public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k]; // smallest 0 0 0... by default
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0)) ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        // WON'T WORK has to use greater() greedy: e.g merge 775 and 779
        // int i=0, j=0, r=0;
        // while(i<nums1.length && j<nums2.length) {
        //     ans[r++] = nums1[i] >= nums2[j] ? nums1[i++] : nums2[j++];
        // }
        // while(i<nums1.length) ans[r++] = nums1[i++];
        // while(j<nums2.length) ans[r++] = nums2[j++];

        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) { // greater than or equals to
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];

        for (int i = 0, j = 0; i < n; ++i) { // j being how many digits selected already
            while (i + k - j < n && j > 0 && ans[j - 1] < nums[i]) j--; // i+k-j < n leave room for j-1: inferred from i+k-(j-1)<=n
            if (j < k) ans[j++] = nums[i];
        }
        // similarly:
        // int i = -1, need = k;
        // while(need > 0){
        //     int d = -1;
        //     for(int j = i+1; j <= n-need; j++) {
        //         if (nums[j] > d) {
        //             i = j;
        //             d = nums[j];
        //         }
        //     }
        //     ans[k-need] = d;
        //     need--;
        // }

        return ans;
    }
}
