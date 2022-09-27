package slidewindow;

/**
 https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 Example 1:
     Input: prices = [7,1,5,3,6,4]
     Output: 5
     Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 Example 2:
     Input: prices = [7,6,4,3,1]
     Output: 0
     Explanation: In this case, no transactions are done and the max profit = 0.
*/
public class Easy_121_Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        /*
        IDEA: Find/Search buyLowestPrice and caculate maxProfit when iteratering the array AT the same time
            n = 6
            [7,1,5,3,6,4]

            idex=1
                --> buyLowestPrice = 7 = prices[0]
        */


        // Bought with lowest price
        int buyLowestPrice = prices[0];

        // Max Profit result
        int maxProfit = 0;

        // Loop from index 1 to end BECAUSE we set buyLowestPrice at index 0
        for(int i=1; i< prices.length;i++){
            if(prices[i] < buyLowestPrice){
                // Update lowest price that bought
                buyLowestPrice = prices[i];
            } else {
                // Caculate max(max, prices[i] - buyLowestPrice)
                maxProfit = Math.max(maxProfit, prices[i] - buyLowestPrice);
            }
        }

        return maxProfit;
    }
}
