import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetect {
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
    // detect cycle
    public static boolean isCycleDirected (ArrayList<Edge> graph[], boolean vis[], int curr, boolean rec[]){
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                if(isCycleDirected(graph, vis, e.dest, rec))return true;
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        CycleDetect g = new CycleDetect();
        g.createGraph(graph);
        System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));
    }
}
