class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int days[] = new int[flowers.length];
        for(int i=0; i<flowers.length; i++) days[flowers[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i=1; i<= right && right < flowers.length; i++) {
            if(i == right) { // a match
                int thisres = Math.max(days[left], days[right]);
                res = Math.min(res, thisres);
                left = right;
                right = left + k + 1;
                continue;
            }

            if(days[i] < days[left] || days[i] < days[right]) {
                left = i;
                right = i + k + 1;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
