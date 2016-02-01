//using reverse
public class Solution {
    public void rotate(int[] nums, int k){
        int n = nums.length;
        k%=n; // get the canonical mod to shift

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}


// O(n) space, 2n time
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            int original_index = (n+i-k)%n;
            res[i] = nums[original_index];
        }

        for(int i=0; i<n; i++){
            nums[i] = res[i];
        }
    }
}
