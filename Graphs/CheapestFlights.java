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
        Queue<Integer[]> q=new LinkedList<>();
        int[] weight=new int[n];
        for(int i=0; i<n; i++){
            if(i!=src){
                weight[i]=Integer.MAX_VALUE; //node
            }
        }
        weight[src]=0;
        q.add(new Integer[]{0, 0, 0}); // {stops, weight, node}
        while (!q.isEmpty()) {
            Integer[] arr=q.remove();
            int node=arr[2];
            int stops=arr[0];
            System.out.println("current stops are "+stops);
            if(stops<=k){
                System.out.println("visiting"+node);

                if(graph[node]!=null){
                    for(int i=0; i<graph[node].size(); i++){
                        int next=graph[node].get(i)[0];
                        int wt=graph[node].get(i)[1];
                            if((arr[1]+wt<weight[next])){
                                System.out.println("updating"+weight[next]+" to "+(weight[node]+wt));
                                System.out.println("At"+next+" K is "+(weight[node]+1));
                                weight[next]=arr[1]+wt;
                                q.add(new Integer[]{stops+1, weight[next], next});
                            }
                    }
                }
            }
        }
        return (weight[dst]<Integer.MAX_VALUE)?(weight[dst]):(-1);
    }
    public static void main(String args[]){
        // int[][] flights={{0,1,1},{0,2,5},{1,2,1},{2,3,1},{3,4,1}};  //7
        int[][] flights={{0,1,1},{0,2,5},{1,2,1},{2,3,1}};  //6
        int price=findCheapestPrice(4, flights, 0, 3, 1);
        System.out.println(price);
    }
}
