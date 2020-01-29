import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int goal = in.nextInt();
        int edges = in.nextInt();

        Vertex[] vertices = new Vertex[goal];
        for(int i = 0; i < goal; i++){
            vertices[i] = new Vertex();
        }
        for(int i = 0; i < edges; i++){
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            vertices[x].edges.add(new Edge(y, 1));
            vertices[y].edges.add(new Edge(x, 1));
        }

        int[] path = dijkstra(vertices, 0);
        System.out.println(path[goal - 1] - 1);
    }



    private static int[] dijkstra(Vertex[] graph, int start) {
        PriorityQueue<sssp> pqueue = new PriorityQueue<>();

        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(dist, -1);

        dist[start] = 0;
        pqueue.add(new sssp(start, 0));
        while(!pqueue.isEmpty()){
            sssp cur = pqueue.remove();

            if(visited[cur.v])
                continue;

            visited[cur.v] = true;
            dist[cur.v] = cur.dist;

            for(Edge e : graph[cur.v].edges){
                if(dist[e.dest] == -1 || dist[cur.v] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[cur.v] + e.weight;
                    pqueue.add(new sssp(e.dest, dist[e.dest]));
                }
            }
        }

        return dist;
    }

    static class sssp implements Comparable<sssp>{
        int v;
        int dist;

        sssp(int v, int dist){
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(sssp sssp) {
            return dist - sssp.dist;
        }
    }

    static class Edge{
        int weight;
        int dest;

        Edge(int d, int w){
            dest = d;
            weight = w;
        }
    }

    static class Vertex{
        ArrayList<Edge> edges = new ArrayList<>();
    }
}
