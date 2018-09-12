// sorting, kinda intuitive.
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;
        
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        
        return end - start + 1;
    }
}

// try to found the boundreis: end should be the last index that is not max from left to right, 
// begin should be the last index that is not min from right to left
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=0; i<n; i++) {
          max = Math.max(max, nums[i]);
          min = Math.min(min, nums[n-1-i]);
          if (nums[i] < max) end = i;
          if (nums[n-1-i] > min) beg = n-1-i; 
        }
        return end - beg + 1;
    }
}