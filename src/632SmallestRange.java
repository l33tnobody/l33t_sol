class Solution {
    class Element {
		int val;
		int idx;
		int row;

		public Element(int r, int i, int v) {
			val = v;
			idx = i;
			row = r;
		}
	}

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val)); // min heap to track the min also the row and the index in the list
        int max = Integer.MIN_VALUE; // can also track max with a max heap but it is not needed.
        int range = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, e.val);
        }
        int start = -1, end = -1;

        while(pq.size() == nums.size()) { // has to have one element in each list
            Element emin = pq.poll();
            if(max - emin.val < range) {
                range = max - emin.val;
                start = emin.val;
                end = max;
            }
            if(emin.idx + 1 < nums.get(emin.row).size()) { // next one in the list exists
                emin.idx++;
                emin.val = nums.get(emin.row).get(emin.idx);
                pq.offer(emin);
                max = Math.max(max, emin.val);
            }
        }

        return new int[]{ start, end };
    }
}
