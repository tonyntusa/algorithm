package slidewindow;

public class _121_Best_Time_To_Buy_And_Sell_Stock {
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
