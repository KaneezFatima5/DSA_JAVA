package DynamicProgramming;

public class maxProductSubArr {
    public static void main(String[] args){
        int[] arr={-2,0,-1};
        // int[] arr={2,3,-2,4};
        int maxProduct=maxProduct(arr);
        System.out.print(maxProduct);
    }
    public static int maxProduct(int[] nums){
        int i=1;
        int max=nums[0];
        int curMax=nums[0];
        int curMin=nums[0];
        while(i<nums.length ){
            if(nums[i]>0){
                max=Math.max(curMin, max);
                curMin=1;
                curMax=curMax*nums[i];
            }else{
                max=Math.max(curMax, max);
                curMax=1;
                curMin=curMin*nums[i];
            }
            i++;
        }
        return max;
    }
}
