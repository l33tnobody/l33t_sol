// if using a max heap of size k, then remove the left most number when the window moves right
// will take O(k) time, which actually makes the runtime to O(nk) where adding number is O(logk)

// using a deque to keep decreasing order in the window, each number will be added once and reomved once
// so time is O(n)

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        int[] res = new int[nums.length - k + 1]; // number of max-es

        Deque<Integer> dq = new ArrayDeque<>(); // to store indices that might be the max,
                                                // key is to store indexes!
        // Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) { // store index in the array so that we know if in
                                                                  // range of k sized window, "if" is equivalent here, need to poll at most once
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
