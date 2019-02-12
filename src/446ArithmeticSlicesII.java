// https://discuss.leetcode.com/topic/67413/detailed-explanation-for-java-o-n-2-solution/2
// at each element, use a hashmap mapping from difference to number of sequences of such that has two or more elements in it
// and ending at the element
// it will become 3 or more in the later runs
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[A.length]; // from d (difference) to number of sequences with two or more numbers in A

        for(int i=0; i<A.length; i++) {
            map[i] = new HashMap<>(i); // i is also number of most number of differences A[i] can get
            for(int j=0; j<i; j++) {
                long diff = (long)A[i] - A[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue; // no possible 3 integers (Int) available, skip no count.

                int d = (int)diff;
                int c2 = map[j].getOrDefault(d, 0); // two or more in the sequence of d ending at j
                res += c2; // three or more in the sequence of d ending at i
                int c1 = map[i].getOrDefault(d, 0);
                map[i].put(d, c1 + c2 + 1); // update two or more in sequences ending at i, with 1 being A[j] to A[i]
            }
        }

        return res;
    }
}
