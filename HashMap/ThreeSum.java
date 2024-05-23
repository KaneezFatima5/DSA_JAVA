import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum{
    public static void main(String args[]){

    }
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        int j=1;
        for(int i=0; i<nums.length; i++){
            int val=(nums[i]+nums[j])*-1;
            if(map.containsKey(val) && map.get(val)!=i && map.get(val)!=j){
                map.get(list)
            }
        }
        return list;

    }
}