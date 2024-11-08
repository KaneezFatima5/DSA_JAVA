import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Integer[]> graph[]=new ArrayList[n];
        for(int i=0; i<flights.length; i++){
            int s=flights[i][0];
            if(graph[s]==null){
                graph[s]=new ArrayList<>();
            }
            Integer[] val={flights[i][1], flights[i][2]};
            graph[s].add(val);
        }
        for(int i=0; i<graph.length; i++){
            if(graph[i]!=null){
            for(int j=0; j<graph[i].size(); j++)
                System.out.println(i+",  "+graph[i].get(j)[0]+", "+graph[i].get(j)[1]);
            }
        }
        Queue<Integer> q=new LinkedList<>();
        int[] weight=new int[n];
        for(int i=0; i<n; i++){
            if(i!=src){
                weight[i]=-1; //node
            }
        }
        weight[src]=0;
        q.add(src);
        int stops=0;
        while (!q.isEmpty() && stops<=k) {
            int node=q.remove();
                System.out.println("visiting"+node);

                if(graph[node]!=null){
                    for(int i=0; i<graph[node].size(); i++){
                        int next=graph[node].get(i)[0];
                        int wt=graph[node].get(i)[1];
                            if((weight[next]==-1 || weight[node]+wt<weight[next])){
                                System.out.println("updating"+weight[next]+" to "+(weight[node]+wt));
                                System.out.println("At"+next+" K is "+(weight[node]+1));
                                weight[next]=weight[node]+wt;
                                q.add(next);
                            }
                    }
                }
                stops++;            
        }
        return (weight[dst]!=-1)?(weight[dst]):(-1);
    }
    // public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    //     boolean[] visited=new boolean[n];
    //     ArrayList<Integer[]> graph[]= new ArrayList[n];
    //     for(int i=0; i<flights.length; i++){
    //         int s=flights[i][0];
    //         if(graph[s]==null){
    //             graph[s]=new ArrayList<>();
    //         }
    //         Integer[] val={flights[i][1], flights[i][2]};
    //         graph[s].add(val);
    //     }
    //     for(int i=0; i<graph.length; i++){
    //         if(graph[i]!=null){
    //         for(int j=0; j<graph[i].size(); j++)
    //             System.out.println(i+",  "+graph[i].get(j)[0]+", "+graph[i].get(j)[1]);
    //         }
    //     }
    //     int[][] weight=new int[n][2];
    //     for(int i=0; i<n; i++){
    //         if(i!=src){
    //             weight[i][0]=-1;
    //             weight[i][1]=0;
    //         }
    //     }
    //     weight[src][0]=0;
    //     weight[src][1]=0;
    //     return (dfs(graph, visited, weight, k, src, dst))? weight[src][1] : -1;
    

    // }
    // public static boolean dfs(ArrayList<Integer[]> graph[], boolean[] visited, int[][] weight, int k, int src, int dest){
    //     if(src==dest && weight[src][1]<=k+1){
    //         return true;
    //     }
    //     visited[src]=true;
    //     if(graph[src]!=null){
    //         for(int i=0; i<graph[src].size(); i++){
    //             int next=graph[src].get(i)[0];
    //             int wt=graph[src].get(i)[1];
    //             if(!visited[next]){
    //                 weight[next][1]=weight[src][1]+1;
    //                 if(dfs(graph, visited, weight, k, next, dest)){
    //                     weight[next][0]=weight[src][0]+wt;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static void main(String args[]){
        // int[][] flights={{0,1,1},{0,2,5},{1,2,1},{2,3,1},{3,4,1}};  //7
        int[][] flights={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};  //6
        int price=findCheapestPrice(4, flights, 0, 3, 1);
        System.out.println(price);
    }
}
