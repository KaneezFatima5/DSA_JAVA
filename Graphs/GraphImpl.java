import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.plaf.synth.SynthStyle;

public class GraphImpl{
    static class Edge{
        int src;
        int dest;
        public Edge(){}
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    public static void bfs(ArrayList<Edge> graph[], int V){
        Boolean[] visited= new Boolean[V];
        for(int i=0; i<visited.length; i++){
            visited[i]=false;
        }
        System.out.println(visited[6]);
        Queue<Integer> queue=new LinkedList<>();
        queue.add(graph[0].get(0).src);
        while (!queue.isEmpty()) {
            int curr=queue.remove();
            if(visited[curr]==false){
                System.out.println(graph[curr].get(0).src);
                for(int i=0; i<graph[curr].size(); i++){
                    queue.add(graph[curr].get(i).dest);
                }
                visited[curr]=true;
            }
        }
    }
    public static void dfs(ArrayList<Edge> graph[], int V, int curr, Boolean[] visisted){
        if(visisted[curr]){
            return;
        }
        System.out.println(graph[curr].get(0).src);
        for(int i=0; i<graph[curr].size(); i++){
            visisted[curr]=true;
            dfs(graph, V, graph[curr].get(i).dest, visisted);
        }
    }
    //All Paths From Source To Target
    public static void allPaths(ArrayList<Edge> graph[], int V, int curr, Boolean[] visited, int dest, String path){
        if(curr==dest){
            path=path+graph[curr].get(0).src;
            System.out.println(path);
            return;
        }
        if(!visited[curr]){
            path=path+graph[curr].get(0).src;
            visited[curr]=true;
            for(int i=0; i<graph[curr].size(); i++){
                allPaths(graph, V, graph[curr].get(i).dest, visited, dest, path);
            }
            visited[curr]=false;
        }
    }
    public static void main(String[] args) {
        int numOfEdges=7;
        ArrayList<Edge> graph[]=new ArrayList[7];
        createGraph(graph); 
        //     1 - 3 
        //   /       \
        // 0       |  5 - 6
        //   \       /
        //     2 - 4 
        // for(int i=0; i<graph.length; i++){
        //     for(int j=0; j<graph[i].size(); j++){
        //         System.out.println(graph[i].get(j).src);
        //     }
        // }
        // bfs(graph, numOfEdges);
        Boolean[] visited= new Boolean[numOfEdges];
        for(int i=0; i<visited.length; i++){
            visited[i]=false;
        }
        // dfs(graph, numOfEdges, 0, visited);
        allPaths(graph, numOfEdges, 0, visited, 5, "");

    }
    
}