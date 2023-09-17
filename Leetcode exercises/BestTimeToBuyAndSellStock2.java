public class BestTimeToBuyAndSellStock2 {
    public static int maxProfit(int[] prices){
        int l=0,r=1; //l=buy and r=sell
        int maxP=0, profit=0;
        while(r<prices.length){
            if(prices[r]>prices[l]){
                profit = prices[r] - prices[l];
                maxP += profit;
                //just this line is changed from the previous problem
                //we need to move l too once we have found profit from one l and one r
                l++;
            }else{
                l=r;
            }
            r++;
        }
        return maxP;
    }

    public static void main(String[] args){
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {7,6,4,3,1};

        System.out.println(maxProfit(prices));
    }
}
