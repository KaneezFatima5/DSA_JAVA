import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class EventualSafeState{
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        HashSet<Integer> safeNodes=new HashSet<>();
        boolean[] stack= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                checkSafeNodes(graph, safeNodes, visited, i, stack);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(safeNodes);
        Collections.sort(res);
        return res;
    }
    public static boolean checkSafeNodes(int[][] graph, HashSet<Integer> safeNodes, boolean[] visited, int curr, boolean[] stack){
        if(!visited[curr] && graph[curr].length==0){
            System.out.println("Saving safe nodes"+curr);
            visited[curr]=true;
            safeNodes.add(curr);
            return false;
        }
        visited[curr]=true;
        stack[curr]=true;
        System.out.println("Adding curr"+curr);
        safeNodes.add(curr);
        for(int i=0; i<graph[curr].length; i++){
            int next=graph[curr][i];
            // cycle case detected
            if(stack[next]){
                System.out.println("Removing curr"+curr);
                safeNodes.remove(curr);
                return true;
            }
            else if(!visited[next]){
                System.out.println("Going for next"+next);
                if(checkSafeNodes(graph, safeNodes, visited,next, stack)){
                    System.out.println("Removing curr2"+curr);
                    safeNodes.remove(curr);
                    return true;
                }            
            }
            
        }
        stack[curr]=false;
        return false;
    }

    public static void main(String args[]){
        // int[][] arr={{1,2},{2,3},{5},{0},{5},{},{}}; //Expeected output is [2,4,5,6] {0, 1, 2, 5,}
        int[][] arr={{},{0,2,3,4},{3},{4},{}}; //Expeected output is [0,1,2,3,4]
        System.out.println(eventualSafeNodes(arr));
    }
}