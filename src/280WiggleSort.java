/*
    // prove Greedy works: only need to compare nums[i] with nums[i-1]
    suppose nums[0 .. i - 1] is wiggled, for position i:

    if i is odd, we already have, nums[i - 2] >= nums[i - 1],

    if nums[i - 1] <= nums[i], then we does not need to do anything, its already wiggled.

    if nums[i - 1] > nums[i], then we swap element at i -1 and i. Due to previous wiggled elements (nums[i - 2] >= nums[i - 1]), we know after swap the sequence is ensured to be nums[i - 2] > nums[i - 1] < nums[i], which is wiggled.

    similarly,

    if i is even, we already have, nums[i - 2] <= nums[i - 1],

    if nums[i - 1] >= nums[i], pass

    if nums[i - 1] < nums[i], after swap, we are sure to have wiggled nums[i - 2] < nums[i - 1] > nums[i].
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if((i&1) == 1){ // odd
                if(nums[i]<nums[i-1]) swap(nums, i, i-1);
            } else { // even
                if(nums[i]>nums[i-1]) swap(nums, i, i-1);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
