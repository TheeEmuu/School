import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int gNodes = in.nextInt();
        int gEdges = in.nextInt();

        ArrayList<Integer>
                gFrom = new ArrayList<>(),
                gTo = new ArrayList<>(),
                gWeight = new ArrayList<>();

        for(int i = 0; i < gEdges; i++){
            gFrom.add(in.nextInt() - 1);
            gTo.add(in.nextInt() - 1);
            gWeight.add(in.nextInt());
        }

        getCost(gNodes, gFrom, gTo, gWeight);
    }

    public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight){
        Vertex[] graph = new Vertex[gNodes];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new Vertex();
        }
        for(int i = 0; i < gFrom.size(); i++){
            graph[gFrom.get(i)].edges.add(new Edge(gTo.get(i), gWeight.get(i)));
            graph[gTo.get(i)].edges.add(new Edge(gFrom.get(i), gWeight.get(i)));
        }

        int[] paths = dijkstra(graph, 0);
        int dist = paths[paths.length - 1];
        if(dist != -1) {
            System.out.println(dist);
        }
        else{
            System.out.println("NO PATH EXISTS");
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
                if(dist[e.dest] == -1 || dist[cur.v] + Math.max(0, e.weight - dist[cur.v]) < dist[e.dest]) {
                    dist[e.dest] = dist[cur.v] + Math.max(0, e.weight - dist[cur.v]);
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