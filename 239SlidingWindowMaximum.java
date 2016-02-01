public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0 || k<=0)
            return new int[0];

        int len = nums.length;
        int[] res = new int[len-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<Integer>();
        //LinkedList<Integer> q = new LinkedList<Integer>(); // works as well, any double ended queue will do

        for(int i=0; i<len; i++){
            // remove index out of range k from front (front is the earliest)
            if(!q.isEmpty() && q.peek()<i-k+1) //change to if also works
                q.poll();
            // remove smaller elements from the back
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
                q.pollLast();

            q.offer(i);

            if(i>=k-1)
                res[ri++] = nums[q.peek()];
        }

        return res;
    }
}
