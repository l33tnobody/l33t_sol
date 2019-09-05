// Time: klogk,
// heap size bounded by k actually bounded also by num1.length (m), k can be at max mn
// worst time mnlogm
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // min heap, bounded by k and actually bounded also by num1.length (m), k can be at at most mn,
        // so runtime actually at most mnlogm
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] + a[1] - b[0] - b[1]);

        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0 });
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] a = pq.poll();
            List<Integer> l = new ArrayList<>();
            l.add(a[0]);
            l.add(a[1]);
            res.add(l);
            if (a[2] == nums2.length - 1)
                continue;
            pq.offer(new int[] { a[0], nums2[a[2] + 1], a[2] + 1 });
        }

        return res;
    }
}

// better estimate on the max of heap size
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return res;

        int m = Math.min(nums1.length, k);
        PriorityQueue<int[]> pq = new PriorityQueue<>(m, (a, b) -> a[0] + a[1] - b[0] - b[1]); // min heap, bounded by k
                                                                                               // actually bounded also
                                                                                               // by num1.length (m), k
                                                                                               // can be at max mn

        for (int i = 0; i < m; i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0 });
        }

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] a = pq.poll();
            List<Integer> l = new ArrayList<>();
            l.add(a[0]);
            l.add(a[1]);
            res.add(l);
            if (a[2] == nums2.length - 1)
                continue;
            pq.offer(new int[] { a[0], nums2[a[2] + 1], a[2] + 1 });
        }

        return res;
    }
}