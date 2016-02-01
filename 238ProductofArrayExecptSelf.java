// easier to understand:
public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];

    int[] t1 = new int[nums.length];
    int[] t2 = new int[nums.length];

    t1[0]=1;
    t2[nums.length-1]=1;

    //scan from left to right
    for(int i=0; i<nums.length-1; i++){
        t1[i+1] = nums[i] * t1[i];
    }

    //scan from right to left
    for(int i=nums.length-1; i>0; i--){
        t2[i-1] = t2[i] * nums[i];
    }

    //multiply
    for(int i=0; i<nums.length; i++){
        result[i] = t1[i] * t2[i];
    }

    return result;
}


// left, right products shift by one
// O(n) time, constant auxiliary space
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i=1; i<len; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int right = 1;
        for (int j=len-2; j>=0; j--){
            right *= nums[j+1];
            res[j] = res[j] * right;
        }

        return res;
    }
}
