// more straightforward:
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i+nums[i]);
        }

        return true;
    }
}

public class Solution {
    public boolean canJump(int[] A) {
        int cur=0;
        int maxnext=A[0];
        //record steps int steps=0;
        for(int i=1;i<A.length;i++){
            if(i>cur){
                if(maxnext<i)   return false;
                cur=maxnext;
                //steps++;
            }
            maxnext=Math.max(maxnext,i+A[i]);
        }
        return true;
    }
}
