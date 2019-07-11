// presum + binary search
class Solution {

    List<Integer> sum;
    int total;
    Random rand;

    public Solution(int[] w) {
        sum = new ArrayList<>();
        int s = 0;
        for(int i=0; i<w.length; i++) {
            s += w[i];
            sum.add(s);
        }

        total = s;
        rand = new Random();
    }

    public int pickIndex() {
        int r = rand.nextInt(total);
        int i = 0, j = sum.size() - 1;
        while(i < j) {
            int m = i + ((j - i) >> 1);
            if(r < sum.get(m)) j = m;
            else i = m+1;
        }

        return i;
    }
}