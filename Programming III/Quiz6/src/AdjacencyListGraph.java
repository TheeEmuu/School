import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AdjacencyListGraph {
    ArrayList<Vertex> graph;
    boolean directed;

    private static class Vertex{
        protected LinkedList<Edge> adjacencies;

        public Vertex(){
            adjacencies = new LinkedList<Edge>();
        }

        public void addEdge(int dest, int weight){
            if(!containsEdge(dest))
                adjacencies.add(new Edge(dest, weight));
        }

        public int removeEdge(int dest) {
            for(int i = 0; i < adjacencies.size(); i++){
                if(adjacencies.get(i).destination == dest) {
                    adjacencies.remove(i);
                    break;
                }
            }

            return -1;
        }

        private boolean containsEdge(int dest){
            for(int i = 0; i < adjacencies.size(); i++){
                if(adjacencies.get(i).destination == dest){
                    return true;
                }
            }

            return false;
        }

        public Iterator<Integer> neighbors(){
            return new Iterator<Integer>() {
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
                public Integer next() {
                    int dest = adjacencies.get(index).destination;
                    index++;
                    return dest;
                }
            };
        }
    }

    private static class Edge{
        protected int destination;
        protected int weight;

        public Edge(int dest, int weight){
            this.destination = dest;
            this.weight = weight;
        }
    }

    public AdjacencyListGraph(int size, boolean dir){
        graph = new ArrayList<Vertex>();
        for(int i = 0; i < size; i++){
            graph.add(new Vertex());
        }
        directed = dir;
    }

    public void addEdge(int start, int end){
        addEdge(start, end, 1);
    }

    public void addEdge(int start, int end, int weight){
        graph.get(start).addEdge(end, weight);
        if(!directed)
            graph.get(end).addEdge(start, weight);
    }

    public void removeEdge(int start, int end){
        graph.get(start).removeEdge(end);
        if(!directed)
            graph.get(end).removeEdge(start);
    }

    public int length(){
        return graph.size();
    }

    public Iterator<Integer> neighbors(int vertex){
        return graph.get(vertex).neighbors();
    }

    public boolean[] dfs(int u){
        boolean[] visited = new boolean[graph.size()];

        return dfs(u, visited);
    }
    private boolean[] dfs(int u, boolean[] visited){
        visited[u] = true;

        Iterator<Integer> it = neighbors(u);
        while(it.hasNext()){
            int next = it.next();
            if(!visited[next])
                dfs(next, visited);
        }

        return visited;
    }
}