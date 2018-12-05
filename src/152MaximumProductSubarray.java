// similar to 53Maximum Subarray in that
// we will need to stop considering previous result
// when current element is bigger/smaller
// but need to keep min and max, since min can become max
public class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0]; // max subarray ends at current element
        int min = nums[0]; // min subarray ends at current element

        for(int i=1; i<nums.length; i++){
            int a = nums[i];
            if (a<0){
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max*a, a);
            min = Math.min(min*a, a);
            res = Math.max(res, max);
        }
        return res;
    }
}
