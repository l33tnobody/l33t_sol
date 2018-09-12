// N(number of ppl) + ages^2, space: O(ages)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;
        
        int res = 0;
        for(int i = 1; i <=120; i++) {
            int cntA = count[i];
            for(int j = 1; j <= 120; j++) {
                int cntB = count[j];
                
                if(j > i ) break;
                if(j <= i * 0.5 + 7) continue;
                // age[B] > 100 && age[A] < 100 no friend request is a redundant condition
                res += cntA * cntB;
                if(j == i) res -= cntA;
            }
        }
        
        return res;
    }
}

// an even faster approach using cumulative sum to speed up calculation: O(N) + O(ages)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;
        //age of B has to be in range (0.5 * A + 7, A], in order to have requests
        int[] sum = new int[121];
        for(int i=1; i<=120; i++) {
            sum[i] = sum[i-1] + count[i];
        }
        
        int res = 0;
        for(int i=15; i<=120; i++) { // 15 is the min age where a range of B exists: (0.5 * A + 7, A]
            // if(count[i] == 0) continue;
            int cntB = sum[i] - sum[i/2 + 7];
            res += count[i] * (cntB - 1); //excluding self
        }
        
        return res;
    }
}