public class Solution { //greedy
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int steps=0;
        for(int i=1, maxnext=A[0], cur=0; i<A.length; i++){
            if(i>cur){
                if(maxnext<i)   return Integer.MAX_VALUE;
                cur=maxnext;
                steps++;
            }
            maxnext=Math.max(maxnext,i+A[i]);
        }
        return steps;
    }
}
