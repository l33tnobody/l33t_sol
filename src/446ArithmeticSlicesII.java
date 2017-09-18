// https://discuss.leetcode.com/topic/67413/detailed-explanation-for-java-o-n-2-solution/2
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length]; // from d (difference) to number of sequences with two or more numbers in A

        for(int i=0; i<A.length; i++) {
            map[i] = new HashMap<>(i); // i is also number of most number of differences A[i] can get
            for(int j=0; j<i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue; // no possible 3 integers available, skip no count.

                int d = (int)diff;
                int c2 = map[j].getOrDefault(d, 0); // two or more in the sequence of d ending at j
                res += c2; // three or more in the sequence of d ending at i
                int c1 = map[i].getOrDefault(d, 0);
                map[i].put(d, c1 + c2 + 1); // update two or more in sequences ending at i
            }
        }

        return res;
    }
}
