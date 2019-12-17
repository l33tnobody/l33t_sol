// slow and fast pointers, swap:
public class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(slow, fast, nums);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int slow, int fast, int[] nums) {
        if (slow == fast)
            return;

        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}

// slow and fast pointers, assign:
public class Solution {
    public void moveZeroes(int[] nums) {
        int slow=0;
        int fast=0;

        while(fast<nums.length){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }

        //from current slow to the end, should be all 0
        while(slow<nums.length){
            nums[slow]=0;
            slow++;
        }
    }
}
