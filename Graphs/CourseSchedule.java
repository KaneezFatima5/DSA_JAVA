public class CourseSchedule{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==1 || prerequisites.length==0){
            return true;
        }
        int curr=prerequisites[0][0];
        boolean[] visited= new boolean[prerequisites.length];
        boolean[] stack = new boolean[prerequisites.length];
        return checkDependency(prerequisites, curr, visited, stack);
    }
    public static boolean checkDependency(int[][] preReq, int curr, boolean[] visited, boolean[] stack){
        visited[curr]=true;
        stack[curr]=true;
        int next=preReq[curr][1];
        if(stack[next]){
            return true;
        }else if(!visited[next]){
            return checkDependency(preReq, next, visited, stack);
        }
        stack[curr]=false;
        return false;
    }
}