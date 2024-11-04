import java.util.ArrayList;
import java.util.List;

public class CourseSchedule{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==1 || prerequisites.length==0){
            return true;
        }
        ArrayList<Integer> graph[]=new ArrayList[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            System.out.println("adding "+prerequisites[i][1] +" to "+prerequisites[i][0]);
            if(graph[prerequisites[i][0]]==null){
                graph[prerequisites[i][0]]=new ArrayList<>();
            }
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<graph.length; i++){
            if(graph[i]!=null){
            for(int j=0; j<graph[i].size(); j++){
                    System.out.println(graph[i].get(j));
                }
            }else{
                System.out.println("null"+i);
            }
        }
        boolean[] visited= new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                System.out.println("moving for in"+i);
                if(!checkDependency(graph, i, visited, stack)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkDependency(ArrayList<Integer> graph[], int curr, boolean[] visited, boolean[] stack){
        visited[curr]=true;
        stack[curr]=true;
        if(graph[curr]==null){
            stack[curr]=false;
            System.out.println("returning from null"+curr);
            return true;
        }
        for(int i=0; i<graph[curr].size(); i++){
            int next=graph[curr].get(i);
            System.out.println("moving next"+next);
            if(stack[next]){
                return false;
            }else if(!visited[next] && !checkDependency(graph, next, visited, stack)){
                return false;
            }
        }
        stack[curr]=false;
        return true;
    }
    public static void main(String args[]){
        // int[][] arr={{0,1},{1, 0}}; //false
        // int[][] arr={{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}; //false
        // int[][] arr={{1,4},{2,4},{3,1},{3,2}};  //true
        // int[][] arr={{0,1},{0,2},{1,2}};  //true
        // int[][] arr={{2,0},{1,0},{3,1},{3,2},{1,3}};  //false
        int[][] arr={{0,1},{0,2},{1,0}};  //false
        System.out.println(canFinish(3, arr));
    }
}