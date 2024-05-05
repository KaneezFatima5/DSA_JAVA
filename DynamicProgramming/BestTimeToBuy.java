package DynamicProgramming;
public class BestTimeToBuy {
    public static void main(String args[]){
        int[] arr={7,1,5,3,6,4};
        System.out.print(maxProfit2(arr));
    }

    //easy 
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

    //medium part-II
    public static int maxProfit2(int[] prices) {
        int min=prices[0];
        int maxPro=0;
        int currProfit=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<min){
                min=prices[i];
            }
            if(currProfit<prices[i]-min){
                currProfit=prices[i]-min;
            }else{
                maxPro=maxPro+currProfit;
                currProfit=0;
                min=prices[i];
            } 
        }
        maxPro=maxPro+currProfit;
        return maxPro;
    }

}
