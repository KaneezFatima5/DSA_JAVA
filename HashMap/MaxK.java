package HashMap;

import java.util.HashMap;

public class MaxK {
    public static void main(String[] args){
        int arr[]={};
        System.out.print(findMaxK(arr));
    }
    public static int findMaxK(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if((map.containsKey(nums[i]*-1))){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], 0);
            }
        }
        // map.forEach((key, value) -> 
        // );
    }
}
