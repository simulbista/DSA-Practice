package Array_String;//121 - Best Time to Buy and Sell Stock (easy)

//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//
//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//
//
//Example 1:
//
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
//
//
//Constraints:
//
//1 <= prices.length <= 105
//0 <= prices[i] <= 104

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices){
        int l=0, r=1;   //l = buy, r = sell
        int maxP = 0, profit =0;
        while(r<prices.length){
            //profitable?
            if(prices[l] < prices[r]){
                profit = prices[r] - prices[l];
                // max profit is the maximum between previous max profit and the current profit
                maxP = Math.max(maxP,profit);
            }else{
                // if price at r is actually lower than price at l, set l to r instead of incrementing l by 1
                l = r;
            }
            r++;
        }
        return maxP;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
