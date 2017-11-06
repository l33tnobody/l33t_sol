class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] hold = new int[prices.length];
        int[] skip = new int[prices.length];
        int[] sell = new int[prices.length];
        // the moment we buy a stock, our balance should decrease
        buy[0] = 0 - prices[0];
        // assume if we have stock in the first day, we are still in deficit
        hold[0] = 0 - prices[0];
        for(int i = 1; i < prices.length; i++) {
            // We can only buy on today if we sold stock
            // or skipped with empty portfolio yesterday
            buy[i] = Math.max(skip[i-1], sell[i-1]) - prices[i];
            // Can only hold if we bought or already holding stock yesterday
            hold[i] = Math.max(buy[i-1], hold[i-1]);
            // Can skip only if we skipped, or sold stock yesterday
            skip[i] = Math.max(skip[i-1], sell[i-1]);
            // Can sell only if we bought, or held stock yesterday
            sell[i] = Math.max(buy[i-1], hold[i-1]) + prices[i] - fee;
        }
        // Get the max of all the 4 actions on the last day.
        int max = Math.max(buy[prices.length - 1], hold[prices.length - 1]);
        max = Math.max(skip[prices.length - 1], max);
        max = Math.max(sell[prices.length - 1], max);
        return max;
    }
}




// not as good as the first one
// or an simpler solution with some confusion on the when the fee would apply
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        int[] hold = new int[l + 1]; //Hold the stock until day i;
        int[] notHold = new int[l + 1]; //Do not hold the stock until day i;
        hold[0] = Integer.MIN_VALUE;

        for (int i = 1; i <= l; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i - 1] - fee); // fee has to be applied for buying
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i - 1]); // fee apply here will give wrong answer
        }

        return notHold[l];
    }
}
