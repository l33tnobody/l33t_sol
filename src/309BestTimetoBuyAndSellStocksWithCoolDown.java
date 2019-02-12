// better solution more straightforward:
// the question actually means only one action is allowed in one day.

// https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking/2

// transition:
// s0[i] = max(s0[i - 1], s2[i - 1]); // Stay at s0, or rest from s2
// s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]); // Stay at s1, or buy from s0
// s2[i] = s1[i - 1] + prices[i]; // Only one way from s1

// base cases: (before 0 day)
// s0 = 0
// s1 = MIN
// s2 = MIN

public class Solution {
    public int maxProfit(int[] prices) {
        int s0 = 0, s1 = Integer.MIN_VALUE, s2 = Integer.MIN_VALUE; // has to start from s0 state

        for(int i=0; i<prices.length; i++) {
            int news0 = Math.max(s0, s2);
            int news1 = Math.max(s1, s0 - prices[i]);
            int news2 = s1 + prices[i];

            s0 = news0; s1 = news1; s2 = news2;
        }

        return Math.max(s0, s2); // s1 after buy cannot be the largest，assume price non-negative
    }
}







// or: https://discuss.leetcode.com/topic/30421/share-my-thinking-process?page=1
// buy[i] = max(sell[i-2]-price, buy[i-1])
// sell[i] = max(buy[i-1]+price, sell[i-1])

public class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy = Integer.MIN_VALUE;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
