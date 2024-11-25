import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ThreeSum{
    public static void main(String args[]){
        int[] nums={-1,0,1,2,-1,-4};
        int[] sorted={-4, -1, -1, 0, 1, 2};
        -4-1+2=-3;<0 p1++
        -4-1+2=-3<0 p1++;
        -4+0+2=-2<0 p1++;
        -4+1+2=-1<0 p1++ p1=p2;

        i=1;



    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> map= new HashSet<>();
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int p1=i+1;
            int p2=nums.length-1;
            while (p1!=p2) {
                int sum=nums[i]+nums[p1]+nums[p2];
                if(sum==0){
                    List<Integer> newList=new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[p1]);
                    newList.add(nums[p2]);
                    map.add(newList);
                }
                if(sum>0){
                    p2--;
                }else{
                    p1++;
                }
            }
        }
        Iterator<List<Integer>> iterator=map.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;

    }
}