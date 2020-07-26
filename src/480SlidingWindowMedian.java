// https://discuss.leetcode.com/topic/79642/short-and-clear-o-nlogk-java-solutions
// priorityqueue removal is O(k) (k is size of the window)
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        boolean useBoth = k % 2 == 0;
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b)->{return (int)((double)b-a);});
        PriorityQueue<Integer> big = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            if(small.size() + big.size()==k){
                Integer toRemove = new Integer(nums[i-k]);
                if(toRemove <= small.peek()) small.remove(toRemove);
                else big.remove(toRemove);
            }
            //always keep small.size() == big.size() or small.size() == big.size()+1
            if(small.size()<=big.size()) small.add(nums[i]);
            else big.add(nums[i]);
            if(big.size()>0){
                while(small.peek()>big.peek()){
                    big.add(small.poll());
                    small.add(big.poll());
                }
            }
            if(small.size() + big.size()==k){
                if(useBoth) res[idx++] = ((double)small.peek() + big.peek())/2.0;
                else res[idx++] = (double)small.peek();
            }
        }
        return res;
    }
}

// improve: use TreeMap(BST map) as PriorityQueue(heap) to have all log(k) performance
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        int idx = 0;
        boolean useBoth = k % 2 == 0;
        // convert to double to avoid int overflow
        TreeMap<Integer, Integer> small = new TreeMap<>((a, b)->{return (int)((double)b-a);});
        int smallSize = 0;
        TreeMap<Integer, Integer> big = new TreeMap<>();
        int bigSize = 0;
        for(int i = 0; i<nums.length; i++){
            if(smallSize + bigSize == k){
                if(nums[i-k] <= small.firstKey()){
                    remove(small, nums[i-k]);
                    smallSize--;
                }else{
                    remove(big, nums[i-k]);
                    bigSize--;
                }
            }

            if(smallSize<=bigSize){
                add(small, nums[i]);
                smallSize++;
            }else{
                add(big, nums[i]);
                bigSize++;
            }
            if(bigSize>0){
                while(small.firstKey()>big.firstKey()){ // equivalent to if
                    add(big, remove(small, small.firstKey()));
                    add(small, remove(big, big.firstKey()));
                }
            }

            if(smallSize + bigSize==k){
                if(useBoth) res[idx++] = ((double)small.firstKey() + big.firstKey())/2.0;
                else res[idx++] = (double)small.firstKey();
            }
        }
        return res;
    }

    private int remove(TreeMap<Integer, Integer> map, int i) {
        map.put(i, map.get(i)-1);
        if(map.get(i)==0) map.remove(i);
        return i;
    }

    private void add(TreeMap<Integer, Integer> map, int i) {
        if(!map.containsKey(i)) map.put(i, 1);
        else map.put(i, map.get(i)+1);
    }
}


// using Multiset in C++:
// https://discuss.leetcode.com/topic/74963/o-n-log-k-c-using-multiset-and-updating-middle-iterator
