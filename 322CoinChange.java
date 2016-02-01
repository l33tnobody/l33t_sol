// DP
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; // means impossible
        int[] fewest = new int[amount + 1];
        fewest[0] = 0;
        for(int i=1; i<=amount; i++) {
            fewest[i] = max;
        }

        for(int i=1; i<=amount; i++) {
           for(int j=0; j<coins.length; j++) {
               if (i>=coins[j]){
                   fewest[i] = Math.min(fewest[i], fewest[i-coins[j]]+1);
               }
           }
        }

        int result = fewest[amount];
        if (result == max)
            result = -1;
        return result;
    }
}

// recursion -- NOT recommended
public class Solution {
    int min = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        count(amount, coins.length-1, coins, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    void count(int amount, int index, int[] coins, int count){
        if (index<0)
            return;

        int c = amount/coins[index];
        for (int i=c; i>=0; i--) {
            int newCount = count + i;
            int rem = amount - i*coins[index];

            if (rem>0 && newCount<min)
                count(rem, index-1, coins, newCount);
            else if (rem==0 && newCount<min)
                min = newCount;
            else //newCount>=min
                break;
        }
    }
}
