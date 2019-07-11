// https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation
/*
    left_part                |        right_part
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
    If we can ensure:
    1) len(left_part) == len(right_part)
    2) max(left_part) <= min(right_part)

    Binary Searching i in [0, m], to find an object `i` that:
    B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
*/

/*
    log(Math.min(m, n))
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // make sure m <= n
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int imin = 0, imax = m, half_len = (m+n)/2; // imin: min number of elements can be put in left for m, imax: max number of the same.

        while(imin <= imax) {
            int i = (imin + imax) / 2;
            int j = half_len - i; // i + j = half the m+n, if total number is odd, median is min of the right
            if(j > 0 && i < m && nums2[j-1] > nums1[i]) { // i < m ==> j > 0 condition on j optional
                imin = i + 1;
            } else if(i > 0 && j < n && nums1[i-1] > nums2[j]) { // i > 0 ==> j < n condition on j optional
                imax = i - 1;
            } else { // find the right i and also j
                int min_of_right = 0;
                if(i == m) min_of_right = nums2[j];
                else if(j == n) min_of_right = nums1[i];
                else min_of_right = Math.min(nums1[i], nums2[j]);

                if((m+n) % 2 == 1) return min_of_right;

                int max_of_left = 0;
                if(i == 0) max_of_left = nums2[j-1];
                else if (j == 0) max_of_left = nums1[i-1];
                else max_of_left = Math.max(nums1[i-1], nums2[j-1]);

                return (max_of_left + min_of_right) / 2.0;
            }
        }

        return -1.0;
    }
}