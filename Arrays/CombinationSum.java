package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combo(){

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> subList= new ArrayList<>();
        for(int i=0; i<candidates.length; i++){
            Integer curSum=0;
            if(candidates[i]<target){
                curSum+=candidates[i];
                subList.add(candidates[i]);
                
            }
        }
    }
    public static void main(String args[]){
        
    }
}
