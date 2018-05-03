class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26]; // track the last index of each char

        for(int i=0; i<S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }

        int start = 0, last = 0; // the partition start and last indexes
        for(int i = 0; i<S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']);
            if(i == last) { // partition
                res.add(last - start + 1);
                start = last + 1; // last will be enlarged in the next iteration
            }
        }

        return res;
    }
}
