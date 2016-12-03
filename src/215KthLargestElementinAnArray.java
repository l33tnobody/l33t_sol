// quick select: O(n), in place
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // k as in smallest
        int l = 0, r = nums.length-1;

        while(l<r){
            int j = partition(nums, l, r);

            if(j < k) {
                l=j+1;
            } else if (j > k){
                r=j-1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r]; // can be randomized
        int j = l;

        for(int i=l; i<r; i++) {
            if(nums[i]<pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, r);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        if(i==j) return;

        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

// heap based: nlg(k) runtime, O(k) space, heap size k
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// sort nlgn time   o 1 space
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
