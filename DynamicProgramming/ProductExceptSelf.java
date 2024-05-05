package DynamicProgramming;

public class ProductExceptSelf {
    public static void main(String args[]){
        int[] nums={1,2,3,4};
        int[] nums3=product(nums);
        for(int i=0; i<nums3.length; i++){
            System.out.print(nums3[i] + ", ");
        }
    }
    public static int[] product(int[] nums){
        int[] nums1=new int[nums.length];
        int[] nums2=new int[nums.length];
        int[] nums3=new int[nums.length];
        nums1[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            nums1[i]=nums1[i-1]*nums[i];
        }
        nums2[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            nums2[i]=nums2[i+1]*nums[i];
        }
        nums3[0]=nums2[1];
        for(int i=1; i<nums.length-1; i++){
            nums3[i]=nums1[i-1]*nums2[i+1];
        }
        nums3[nums3.length-1]=nums1[nums1.length-2];
        return nums3;

    }
}
