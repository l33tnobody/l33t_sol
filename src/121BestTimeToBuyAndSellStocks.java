// greedy one pass:
// use track min so far
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int p : prices){
            profit = Math.max(profit, p-min);
            min = Math.min(min, p);
        }
        return profit;
    }
}
