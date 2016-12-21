// can also use k select (quick select) with k being 3

public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<Integer>();

        for(int n : nums) {
            if (!set.contains(n)) {
                pq.offer(n);
                set.add(n);
                if (pq.size() > 3) {
                    pq.poll(); // no need to update set since, for sure have the 3rd max and the one got polled is not 3rd max
                }
            }
        }

        if (pq.size()<3) {
            while(pq.size()>1) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
