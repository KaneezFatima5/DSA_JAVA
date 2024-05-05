package DynamicProgramming;

public class maxProductSubArr {
    public static void main(String[] args){
        // int[] arr={-2,0,-1};
        int[] arr={-2,3,-4};
        int maxProduct=maxProduct(arr);
        System.out.print(maxProduct);
    }
    public static int maxProduct(int[] nums){
        int curmin=nums[0];
        int curMax=nums[0];
        int max=curmin;
        for(int i=1; i<nums.length; i++){
            if(curmin<nums[i]){
                curmin=curmin*nums[i];
                curmin=nums[i];
            }else{
                
            }
            if(max<curmin){
                max=curmin;
            }
        }
        return max;
    }
}
