package Ghraphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {
    public static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s,int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2,2));

        graph[1].add(new Edge(1, 2,10));
        graph[1].add(new Edge(1, 3,0));

        graph[2].add(new Edge(2, 0,2));
        graph[2].add(new Edge(2, 1,10));
        graph[2].add(new Edge(2, 3,-1));

        graph[3].add(new Edge(3, 1,0));
        graph[3].add(new Edge(3, 2,-1));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int wt;

        public Pair(int n,int w){
            this.node = n;
            this.wt = w;
        }

        @Override
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }

    public static void dijkstraAlgo(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dis = new int[V];
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dis[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;

                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);

                    int u = e.src;
                    int v = e.dest;

                    if(dis[u]+e.weight<dis[v]){
                        dis[v] = dis[u]+e.weight;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }

        for(int i=0;i<V;i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        Dijkstra g = new Dijkstra();
        g.createGraph(graph);

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println("Adjecent:"+" "+e.dest+" "+"Weight:"+" "+e.weight);
        // }
        g.dijkstraAlgo(graph, 0, 4);
    }
}
