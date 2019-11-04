import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/primsmstsub/problem
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int nodes = in.nextInt();
        int edges = in.nextInt();

        Vertex[] graph = new Vertex[nodes];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new Vertex();
        }
        for(int i = 0; i < edges; i++){
            int source = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            int weight = in.nextInt();
            graph[source].edges.add(new Edge(source, dest, weight));
            graph[dest].edges.add(new Edge(dest, source, weight));
        }

        int startNode = in.nextInt() - 1;

        Vertex[] mst = prims(graph, startNode);

        int totalWeight = 0;
        for(Vertex v : mst){
            if(v.edges != null) {
                for (Edge e : v.edges) {
                    totalWeight += e.weight;
                }
            }
        }

        System.out.println(totalWeight);
    }

    public static Vertex[] prims(Vertex[] graph, int startNode){
        Vertex[] mst = new Vertex[graph.length];
        for(int i = 0; i < graph.length; i++){
            mst[i] = new Vertex();
        }

        boolean[] visited = new boolean[graph.length];

        Vertex first = graph[startNode];
        visited[startNode] = true;
        PriorityQueue<Edge> queue = new PriorityQueue<>(first.edges);


        while(!queue.isEmpty()){
            Edge cur = queue.remove();

            if(!visited[cur.dest]){
                mst[cur.source].edges.add(cur);
                visited[cur.dest] = true;
                queue.addAll(graph[cur.dest].edges);
            }
        }

        return mst;
    }

    static class Edge implements Comparable<Edge> {
        int source;
        int weight;
        int dest;

        Edge(int s, int d, int w){
            source = s;
            dest = d;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static class Vertex{
        ArrayList<Edge> edges = new ArrayList<>();
    }
}
