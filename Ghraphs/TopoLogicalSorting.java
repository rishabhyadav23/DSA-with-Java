// Topological Sorting only apply on directed and asyclic graphs

package Ghraphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopoLogicalSorting {
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
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // method for topological sorting

    public static void topSortSolve(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> st) {
        vis[curr] = true;
    
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortSolve(graph, e.dest, vis, st);
            }
        }
    
        st.push(curr);
    }
    

    public static void topSort(ArrayList<Edge>[] graph, int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
    
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortSolve(graph, i, vis, st);
            }
        }
    
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];

        TopoLogicalSorting g = new TopoLogicalSorting();
        g.createGraph(graph);

        g.topSort(graph, V);
    }
}
