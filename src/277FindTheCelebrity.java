// kinda like a knows b => a < b so the celebrity is the largest number
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;
        for(int i=1; i<n; i++) {
            if (knows(cand, i)) {
                cand = i;
            }
        }

        for (int i=0; i<n; i++) {
            if (i!=cand && (!knows(i, cand) || knows(cand, i))) return -1;
        }

        return cand;
    }
}
