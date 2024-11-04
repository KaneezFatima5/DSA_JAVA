import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EventualSafeState{
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited=new boolean[graph.length];
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                checkSafeNodes(graph, safeNodes, visited, i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    public static void checkSafeNodes(int[][] graph, List<Integer> safeNodes, boolean[] visited, int curr){
        if(!visited[curr] && graph[curr].length==0){
            System.out.println("Saving safe nodes"+curr);
            safeNodes.add(curr);
        }
        visited[curr]=true;
        for(int i=0; i<graph[curr].length; i++){
            int next=graph[curr][i];
            if(graph[next].length==0){
                System.out.println("Saving Terminal nodes"+curr);
                safeNodes.add(curr);
            }
            if(!visited[next]){
                System.out.println("Going for next"+next);
                checkSafeNodes(graph, safeNodes, visited,next);
            }
        }
    }

    public static void main(String args[]){
        int[][] arr={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(arr));
    }
}