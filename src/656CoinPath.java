class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int n = A.length;
        int[] c = new int[n]; // cost
        int[] p = new int[n]; // previous index
        int[] l = new int[n]; // length: the longer the better
        Arrays.fill(c, Integer.MAX_VALUE);
        Arrays.fill(p, -1);
        c[0] = A[0]; // can assign 0 here but to reflect the real cost add the first cost in

        for(int i=0; i<n; i++) {
            if(A[i] == -1) continue;
            for(int j=Math.max(i-B, 0); j<i; j++) {
                if(A[j] == -1) continue;
                if(c[j]+A[i] < c[i] || (c[j]+A[i] == c[i] && l[j]+1 > l[i])) { // longer the sequence, smaller the lexicographical is; not strict proof see https://discuss.leetcode.com/topic/98491/java-22-lines-solution-with-proof
                    c[i] = c[j] + A[i];
                    p[i] = j;
                    l[i] = l[j] + 1;
                }
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        for(int cur=n-1; cur>=0; cur=p[cur]) path.offerFirst(cur+1); // index starting at 1 according to the question

        return path.peekFirst() == 1 ? path : Collections.emptyList();
    }
}
