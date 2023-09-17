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
