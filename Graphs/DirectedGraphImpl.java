import java.util.ArrayList;

public class DirectedGraphImpl {
    public static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.dest=d;
            src=s;
        }
        Edge(){}
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 3));

    }
    public static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean[] visisted=new boolean[graph.length];
        boolean[] stack=new boolean[graph.length];
        stack[0]=true;
        return detectCycle(graph, 0, visisted, stack);
    }
    public static boolean detectCycle(ArrayList<Edge> graph[], int curr, boolean[] visisted, boolean[] stack){
        visisted[curr]=true;
        stack[curr]=true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                System.out.println(e.dest);
                return true;
            }else if(!visisted[e.dest]){
                return detectCycle(graph, e.dest, visisted, stack);
            }
        }
        stack[curr]=false;
        return false;
    }

    public static void main(String args[]){
        ArrayList<Edge> graph[]= new ArrayList[4];
        createGraph(graph);
        System.out.println(isCyclic(graph));
    }
}
