// Bucket Sort, Array Based, O(n) time and space
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // frequency ranges from nums.length times to 1
        List<Integer>[] freq = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency  = entry.getValue();
            if(freq[frequency] == null) {
                freq[frequency] = new ArrayList<>();
            }
            freq[frequency].add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for(int i=freq.length-1; i>0 && k>0; i--) {
            if(freq[i]!=null) {
                res.addAll(freq[i]);
                k-=freq[i].size();
            }
        }

        return res;
    }
}

// based on heap nlogn time, O(n) space
// or after getting all the frequency, use a min heap on the frequency of size
// k: time (n+k)logk, space n+k
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }
        return res;

        // better: min heap
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) ->
        // a.getValue()-b.getValue());
        // for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
        // pq.offer(entry);
        // if(pq.size() > k) pq.poll();
        // }

        // List<Integer> res = new LinkedList<>();
        // while(!pq.isEmpty()) {
        // res.add(0, pq.poll().getKey());
        // }
        // return res;
    }
}



// k quick select based: O(n) time and space
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        quickSelect(list, k); // this will partial sort the list with all the bigger ones to the left
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++) {
            res.add(list.get(i).getKey());
        }

        return res;
    }

    private void quickSelect(List<Map.Entry<Integer, Integer>> list, int k) {
        int l=0, r=list.size()-1;
        while(l<r) {
            int j = partition(list, l, r);
            if(j<k) {
                l=j+1;
            } else if(j>k) {
                r=j-1;
            } else {
                break;
            }
        }
    }

    private int partition(List<Map.Entry<Integer, Integer>> list, int l, int r) {
        Map.Entry<Integer, Integer> e = list.get(r);
        int j=l;
        for(int i=l; i<r; i++) {
            if(list.get(i).getValue() > e.getValue()) {
                swap(list, i, j);
                j++;
            }
        }
        swap(list, r, j);

        return j;
    }

    private void swap(List<Map.Entry<Integer, Integer>> list, int i, int j) {
        if(i==j) return;

        Map.Entry<Integer, Integer> tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
