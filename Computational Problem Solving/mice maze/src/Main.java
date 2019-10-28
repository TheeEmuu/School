import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        while(N-- > 0) {
            int sz = in.nextInt();
            int start = in.nextInt() - 1;
            int timer = in.nextInt();
            int M = in.nextInt();


            Vertex[] graph = new Vertex[sz];
            for(int i = 0; i < graph.length; i++){
                graph[i] = new Vertex();
            }
            for(int i = 0; i < M; i++){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                int w = in.nextInt();

                graph[v].edges.add(new Edge(u, w));
            }

            int[] times = dijkstra(graph, start);
            int count = 0;
            for (int t : times)
                if (t != -1 && t <= timer)
                    count++;

            System.out.println(count);
            if(N > 0)
                System.out.println();
        }
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
}

class Edge{
    int weight;
    int dest;

    Edge(int d, int w){
        dest = d;
        weight = w;
    }
}

class Vertex{
    ArrayList<Edge> edges = new ArrayList<>();
}
