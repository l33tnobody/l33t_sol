public class Solution {
    // for previous smaller permutation, follow the reverse process
    public void nextPermutation(int[] nums) {
        int len = nums.length;

        int i = len - 1;
        while(i>0 && nums[i] <= nums[i-1]) i--;

        if (i==0) { // digits ascending, no next greater, return smallest i.e. reverse nums
            reverse(nums, 0, len-1);
            return;
        }

        i--; // the first descending digit
        int j=len-1;

        while(nums[j] <= nums[i]) j--; // first greater one than nums[i]
        swap(nums, i, j);
        reverse(nums, i+1, len-1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] nums, int s, int e) {
        while(s < e) {
            swap(nums, s, e);
            s++;
            e--;
        }
    }
}
