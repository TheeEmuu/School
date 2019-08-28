import java.util.*;

public class ALGraph {
    private static class Vertex {
        int v;
        Edge firstEdge;

        public Vertex(int v) {
            this.v = v;
            this.firstEdge = null;
        }
    }

    private static class Edge {
        int dest;
        int weight;
        Edge next;

        public Edge(int d, int w) {
            this(d, w, null);
        }

        public Edge(int d, int w, Edge n) {
            this.dest = d;
            this.weight = w;
            this.next = n;
        }
    }

    private ArrayList<Vertex> graph;
    private boolean isDirected;

    public ALGraph(int sz, boolean isDirected) {
        graph = new ArrayList<>(sz);
        for (int i=0; i<sz; ++i)
            graph.add(new Vertex(i));

        this.isDirected = isDirected;
    }

    public void addEdge(int u, int v, int w) {
        // first, see if this edge is present already
        Vertex eww = graph.get(u);

        if (eww.firstEdge == null) {
            eww.firstEdge = new Edge(v, w);
        }
        else {
            Edge cur = eww.firstEdge;

            while (true) {
                if (cur.dest == v) {
                    cur.weight = w;
                    break;
                }
                else if (cur.next == null) {
                    eww.firstEdge = new Edge(v, w, eww.firstEdge);
                    break;
                }
                else
                    cur = cur.next;
            }
        }
    }

    public static class ShortPaths {
        public int[] dist;
        public int[] pred;

        public ShortPaths(int[] d, int[] p) {
            dist = d;
            pred = p;
        }
    }

    private static class DijkstraBK implements Comparable<DijkstraBK> {
        int vertex;
        int dist;

        public DijkstraBK(int v, int d) {
            vertex = v;
            dist = d;
        }

        @Override
        public int compareTo(DijkstraBK o) {
            return this.dist - o.dist;
        }
    }

    public ShortPaths dijkstra(int start) {
        int[] dist = new int[graph.size()];
        int[] pred = new int[graph.size()];

        boolean[] known = new boolean[graph.size()];

        Arrays.fill(dist, -1); // -1 == infinity
        Arrays.fill(pred, -1); // -1 == no predecessor

        PriorityQueue<DijkstraBK> queue = new PriorityQueue<>();

        // prime the data structures
        pred[start] = start;
        dist[start] = 0;
        queue.add(new DijkstraBK(start, 0));

        while (!queue.isEmpty()) {
            DijkstraBK cur = queue.remove();
            int u = cur.vertex;

            if (known[u])
                continue;

            known[u] = true;

            // relax all the neighbors of cur

            for (Edge e = graph.get(u).firstEdge; e != null; e = e.next){
                int v = e.dest;
                if (!known[v]) {
                    if (dist[v] == -1 || dist[u] + e.weight < dist[v]) {
                        dist[v] = dist[u] + e.weight;
                        pred[v] = u;
                        queue.add(new DijkstraBK(v, dist[v]));
                    }
                }
            }
        }
        return new ShortPaths(dist, pred);
    }

    public static boolean firstHeap(int[] array, int n){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.push(array[0]);
        int index = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            index++;
            if(index >= n) break;

            if(array[index] < cur)
                return false;
            queue.add(array[index]);

            index++;
            if(index >= n) break;

            if(array[index] < cur)
                return false;
            queue.add(array[index]);
        }

        return true;
    }

    //This method runs in O(V) + O(V) * O(E) time
    //so, O(V + V * E), as we first iterate over
    //each vertex to assign it to infinity, and then
    //go to each vertex and iterate over its edges to
    //find the shortest path

    //this runs slower than Dijkstra's, as Dijkstra's
    //runs at worst O(V + E)
    public int[] shortestPath(){
        int[] dist = new int[graph.size()];

        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;

        for(Vertex x : graph){
            int u = x.v;
            for(Edge e = graph.get(u).firstEdge; e != null; e = e.next){
                int v = e.dest;
                if(dist[v] == -1 ||dist[u] + e.weight < dist[v])
                    dist[v] = dist[u] + e.weight;
            }
        }

        return dist;
    }
}
