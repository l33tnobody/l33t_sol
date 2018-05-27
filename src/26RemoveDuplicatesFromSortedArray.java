public class Solution {
    public int removeDuplicates(int[] A) {
        int n = nums.length;
        if(n == 0) return 0;

        int i = 0;
        for (int j = 1; j < n; j++) {
            if(nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }

        return i+1;
    }
}

// or:
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if(n == 0) return 0;

    int i = 1;
    for (int j = 1; j < n; j++) {
        if(nums[j] != nums[j-1]) {
            nums[i++] = nums[j];
        }
    }

    return i;
}
