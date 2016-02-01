public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
