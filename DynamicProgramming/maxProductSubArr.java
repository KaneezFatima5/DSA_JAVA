package DynamicProgramming;

public class maxProductSubArr {
    public static void main(String[] args){
        // int[] arr={-2,0,-1};
        // int[] arr={2, 3, -2, 4};
        // int[] arr={-2,3,-4};
        // int[] arr={0,2};
        int[] arr={2,-5,-2,-4,3}; //24, -10/-10, -2/20, -4/-100, 3/-300
        int maxProduct=maxProduct(arr);
        System.out.print(maxProduct);
    }
    public static int maxProduct(int[] nums){
        int curmin=nums[0];
        int curMax=nums[0];
        int max=curmin;
        for(int i=1; i<nums.length; i++){
            if(curMax>0){
                curMax=curMax*nums[i];
            }else{
                curMax=nums[i];
            }
                curmin=curmin*nums[i];

            if(max<Math.max(curMax, curmin)){
                max=Math.max(curMax, curmin);
            }
        }
        return max;
    }
}
