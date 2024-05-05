package DynamicProgramming;

public class MaxSumSubArray {
    public static void main(String[] args){
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSumSubarray(arr));
    }
    public static int maxSumSubarray(int nums[]) {
        int currSum=nums[0];
        int maxSum=nums[0];
        int i=1;
        while(i<nums.length){
            if(currSum>0){
                currSum=currSum+nums[i];
            }else{
                currSum=nums[i];
            }
            if(maxSum<currSum){
                maxSum=currSum;
            }
            i++;
        }
        return maxSum;
        
    }
}
