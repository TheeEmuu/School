import java.util.*;

public class AdjacencyListGraph {
    ArrayList<Vertex> graph;
    boolean directed;

    private static class Vertex{
        protected LinkedList<Edge> adjacencies;
        protected int location;

        public Vertex(int l){
            adjacencies = new LinkedList<Edge>();
            location = l;
        }

        public void addEdge(Vertex dest, int weight){
            if(!containsEdge(dest))
                adjacencies.add(new Edge(this, dest, weight));
        }

        public Edge removeEdge(Vertex dest) {
            for(int i = 0; i < adjacencies.size(); i++){
                if(adjacencies.get(i).destination.equals(dest)) {
                    adjacencies.remove(i);
                    break;
                }
            }


            return new Edge();
        }

        private boolean containsEdge(Vertex dest){
            for(int i = 0; i < adjacencies.size(); i++){
                if(adjacencies.get(i).destination.equals(dest)){
                    return true;
                }
            }

            return false;
        }

        public Iterator<Vertex> neighbors(){
            return new Iterator<Vertex>() {
                int index = 0;

                @Override
                public boolean hasNext() {
                    try{
                        adjacencies.get(index);
                        return true;
                    }
                    catch(Exception e){
                        return false;
                    }
                }

                @Override
                public Vertex next() {
                    Vertex dest = adjacencies.get(index).destination;
                    index++;
                    return dest;
                }
            };
        }
    }

    private static class Edge{
        protected Vertex source;
        protected Vertex destination;
        protected int weight;

        public Edge(Vertex source, Vertex dest, int weight){
            this.source = source;
            this.destination = dest;
            this.weight = weight;
        }

        private Edge(){
            this.source = new Vertex(-1);
            this.destination = new Vertex(-1);
            this.weight = -1;
        }
    }

    public AdjacencyListGraph(int size, boolean dir){
        graph = new ArrayList<Vertex>();
        for(int i = 0; i < size; i++){
            graph.add(new Vertex(i));
        }
        directed = dir;
    }

    public void addEdge(int start, int end){
        addEdge(start, end, 1);
    }

    public void addEdge(int start, int end, int weight){
        Vertex s = graph.get(start);
        Vertex e = graph.get(end);

        graph.get(start).addEdge(e, weight);
        if(!directed)
            graph.get(end).addEdge(s, weight);
    }

    private void addEdge(Edge e){
        addEdge(e.source.location, e.destination.location, e.weight);
    }

    public void removeEdge(int start, int end){
        Vertex s = graph.get(start);
        Vertex e = graph.get(end);

        graph.get(start).removeEdge(e);
        if(!directed)
            graph.get(end).removeEdge(s);
    }

    private void removeEdge(Edge e){
        removeEdge(e.source.location, e.destination.location);
    }

    public int size(){
        return graph.size();
    }

    public Iterator<Vertex> neighbors(int vertex){
        return graph.get(vertex).neighbors();
    }

    public boolean[] dfs(int u){
        boolean[] visited = new boolean[graph.size()];

        return dfs(u, visited);
    }
    private boolean[] dfs(int u, boolean[] visited){
        visited[u] = true;

        Iterator<Vertex> it = neighbors(u);
        while(it.hasNext()){
            Vertex next = it.next();
            if(!visited[next.location])
                dfs(graph.indexOf(next), visited);
        }

        return visited;
    }

    public AdjacencyListGraph Prim() {
        // pre-conditions: this is a connected, undirected graph
        AdjacencyListGraph tree = new AdjacencyListGraph(graph.size(), false);
        boolean[] inTree = new boolean[graph.size()];

        // start with vertex 0
        inTree[0] = true;
        // add n-1 edges
        for (int i=0; i<graph.size()-1; ++i) {
            // find the next edge to add
            int min = -1;
            Edge bestEdge = null;
            for (int j=0; j<graph.size(); ++j) {
                if (inTree[j]) {
                    for (Edge e : graph.get(j).adjacencies) {
                        if (!inTree[e.destination.location] && (min == -1 || e.weight < min)) {
                            min = e.weight;
                            bestEdge = e;
                        }
                    }
                }
            }
            tree.addEdge(bestEdge.source.location, bestEdge.destination.location);
            inTree[bestEdge.destination.location] = true;
        }
        return tree;
    }

    public AdjacencyListGraph Kruskal() {
        AdjacencyListGraph tree = new AdjacencyListGraph(graph.size(), false);
        ArrayList<Edge> edges = new ArrayList<>();

        for(Vertex x : graph){
            edges.addAll(x.adjacencies);
        }

        for(int i = 1; i < edges.size(); i++){
            Edge key = edges.get(i);
            int j = i - 1;

            while(j >= 0 && edges.get(j).weight > key.weight){
                edges.set(j + 1, edges.get(j));
                j -= 1;
            }

            edges.set(j + 1, key);
        }

        int edgeCount = 0;

        for(int i = 0; i < edges.size(); i++){
            if(!createsCycle(tree, edges.get(i))){
                edgeCount++;
                if(edgeCount == graph.size() - 1)
                    break;
            }
        }

        return tree;
    }
    private boolean createsCycle(AdjacencyListGraph tree, Edge e){
        boolean[] visited = new boolean[graph.size()];
        tree.addEdge(e);

        for(Vertex x : tree.graph){
            Iterator<Vertex> itt = x.neighbors();

            while(itt.hasNext()){
                Vertex next = itt.next();

                if(!visited[next.location]){
                    visited[next.location] = true;
                }
                else {
                    removeEdge(e);
                    return true;
                }
            }
        }

        return false;
    }
}