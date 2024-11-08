import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dakjistra {
    public static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        
    }
    static class Pair implements Comparable<Pair>{
        int node; //src;
        int wt;
        Pair(int n, int w){
            this.node=n;
            this.wt=w;
        }
        @Override
        public int compareTo(Pair p){
            return this.wt - p.wt;
        }

    }
    public static int[] Dijkstra(ArrayList<Edge> graph[], int src, int dest){
        boolean[] visited=new boolean[graph.length];
        int[] weight=new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i!=src){
                weight[i]=Integer.MAX_VALUE;
            }
        }
        weight[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();[;/]
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            int node=pq.remove().node;
            if(!visited[node]){
                visited[node]=true;
                for(int i=0; i<graph[node].size(); i++){
                    int next=graph[node].get(i).dest;
                    if(weight[node]+graph[node].get(i).wt<weight[next]){
                        weight[next]=weight[node]+graph[node].get(i).wt;
                        pq.add(new Pair(next, weight[next]));
                    }
                }
            }

        }
        return weight;
    }
    public static void main(String args[]){
        int V=6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);
        int[] weights=Dijkstra(graph, 0, 4);  //{0, 2, 3, 8, 6, 9}
        for(int i=0; i<weights.length; i++){
            System.out.print(weights[i]+", ");
        }
    }
}
