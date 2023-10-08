package Array_String;//122. Best Time to Buy and Sell Stock II (medium)

// on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Total profit is 4.
//Example 3:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices){
        int maxP=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]< prices[i]){
                maxP += prices[i] - prices[i-1];
            }
        }
        return maxP;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
//        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }
}
