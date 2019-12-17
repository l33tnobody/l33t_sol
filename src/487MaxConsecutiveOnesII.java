// sliding window generalized to k flips
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0, k = 1; // k for number of 0s can be flipped

        for(int l = 0, h = 0; h < nums.length; h++) {
            if(nums[h] == 0) count++;
            while(count > k) {
                if(nums[l] == 0) count--;
                l++;
            }
            max = Math.max(max, h - l + 1);
        }

        return max;
    }
}

// follow up question:
// can't store all numbers coming from the stream as it's too large to hold in memory.
// can use biginteger to hold result and index, use a queue to track indexes for zeros
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, k = 1; // k for number of 0s can be flipped
        Queue<Integer> zeroIndex = new LinkedList<>();

        for(int l = 0, h = 0; h < nums.length; h++) {
            if(nums[h] == 0) zeroIndex.offer(h);
            if(zeroIndex.size() > k) l = zeroIndex.poll() + 1;

            max = Math.max(max, h - l + 1);
        }

        return max;
    }
}

// ^^ when k == 1 the queue recording zero indexes can be replaced with an integer:
public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0, q = -1;
    for (int l = 0, h = 0; h < nums.length; h++) {
        if (nums[h] == 0) {
            l = q + 1;
            q = h;
        }
        max = Math.max(max, h - l + 1);
    }
    return max;
}
