package Ghraphs;

import java.util.*;

public class ImplenmentWeightedGraph {

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

    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];

        ImplenmentWeightedGraph g = new ImplenmentWeightedGraph();
        g.createGraph(graph);

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.println("Adjecent:"+" "+e.dest+" "+"Weight:"+" "+e.weight);
        // }

        g.bfs(graph, V);
    }
    
}
