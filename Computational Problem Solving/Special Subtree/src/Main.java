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
            graph[in.nextInt()].edges.add(new Edge(in.nextInt(), in.nextInt()));
        }


    }

    public static Vertex[] prims(Vertex[] graph){
        Vertex[] mst = new Vertex[graph.length];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new Vertex();
        }

        boolean[] visited = new boolean[graph.length];

        Vertex first = graph[0];
        visited[0] = true;
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(first);

        while(!queue.isEmpty()){
            Vertex cur = queue.remove();
            Edge bestWeight = new Edge(1, 100001);
            for(Edge e : cur.edges){
                if(e.compareTo(bestWeight) < 0)
                    bestWeight = e;
            }

            mst[]
        }
    }

    static class Edge implements Comparable<Edge> {
        int weight;
        int dest;

        Edge(int d, int w){
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
