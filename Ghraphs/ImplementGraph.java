package Ghraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ImplementGraph {

    public static class Edge{
        int src;
        int dest;


        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public void createGraph(ArrayList<Edge>[] graph){

        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        //graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // bfs for a divided graph

    public static void divBfs(ArrayList<Edge> graph[], int V, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // dfs
    //O(V+E)
    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis){
        System.out.print(curr+" ");

        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    //print all paths between two nodes
    //O(v^V)
    public static void printAll(ArrayList<Edge> graph[],boolean vis[],int curr,String path,int tar){
        if(curr==tar){
            System.out.println(path);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                vis[curr] = true;
                printAll(graph, vis, e.dest, path+" "+e.dest, tar);
                vis[curr] = false;
            }
        }

    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        ImplementGraph g = new ImplementGraph();
        g.createGraph(graph);

        // for(int i=0;i<graph[2].size();i++){
        //     Edge e = graph[2].get(i);
        //     System.out.print(e.dest+" ");
        // }

        // g.bfs(graph, V);

        // System.out.println();

        boolean[] vis = new boolean[V];
        //  for(int i=0;i<V;i++){
        //      if(vis[i]==false){
        //          g.dfs(graph, i, vis);
        //      }
        //  }

       // g.dfs(graph, 0, vis);

        int s=0, tar = 5;
        g.printAll(graph, new boolean[V], s, "0", tar);
        System.out.println();
    }
    
}
