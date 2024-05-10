import java.util.ArrayList;
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
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int val=(nums[i]+nums[j])*-1;
                if(map.containsKey(val) && map.get(val)!=i && map.get(val)!=j){
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(val);
                    map.remove(val);
                    map.remove(nums[i]);
                    list.add(l);
                }
            }
        }
        return list;

    }
}