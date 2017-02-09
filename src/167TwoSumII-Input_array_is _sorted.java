public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i1 = 0, i2 = numbers.length - 1;

        while(i1 < i2) {
            int sum = numbers[i1] + numbers[i2];
            if (sum > target) {
                i2--;
            } else if (sum < target){
                i1++;
            } else {
                break;
            }
        }

        res[0] = i1 + 1;
        res[1] = i2 + 1;
        return res;
    }
}
