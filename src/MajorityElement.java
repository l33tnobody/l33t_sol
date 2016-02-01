public class Solution {
    // this algorithm is called majority vote.
    // O(n) time and O(1) space
    public int majorityElement(int[] nums) {
        int result=0; // means unknown;
        int count=0;

        for (int e : nums){
            if (count==0){
                result=e;
                count=1;
            } else if (result==e){
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}

// other methods include:
//     sorting and getting the middle element at n/2 position
//     counting and reporting
