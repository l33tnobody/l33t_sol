// Reservoir Sampling: just like 382, case k=1
// 1/(1+0) chance replace, 1/(1+1) chance replace ...(assume total n times the data) 
// 1 / (1 + n - 1) = 1 / n, makes each occurrence 1/n chance

class Solution {
    int[] mynums;
    Random rand;

    public Solution(int[] nums) {
        mynums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int res = -1, index = -1, i = 0; // i is the index for reservoir sampling
        
        for(int n : mynums) {
            index++;
            if(n != target) continue;
            
            if(rand.nextInt(1 + i) == 0) {
                res = index;
            }
            i++;
        }
        
        return res;
    }
}