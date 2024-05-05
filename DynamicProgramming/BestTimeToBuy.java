package DynamicProgramming;
public class BestTimeToBuy {
    public static void main(String args[]){
        int[] arr={7,1,5,3,6,1,4};
        System.out.print(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int buy=prices[0];
        int maxPro=0;
        for(int i=1; i<prices.length; i++){
            if(maxPro<(prices[i]-buy)){
                maxPro=prices[i]-buy;
            }
            if(prices[i]<buy){
                buy=prices[i];
            }

        }
        return maxPro;
    }
}
