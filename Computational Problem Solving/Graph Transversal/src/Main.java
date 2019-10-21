import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args){

    }

    public ArrayList<Integer> topSort(Vertex[] graph){
        ArrayList<Integer> list = new ArrayList<>();

        int[] inDegree = new int[graph.length];

        for(Vertex v : graph){
            for (Edge e : v.edges){
                inDegree[e.dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.remove();
            list.add(cur);
            for(Edge e : graph[cur].edges){
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0)
                    queue.add(inDegree[e.dest]);
            }
        }

        return list;
    }

    static class Vertex {
        ArrayList<Edge> edges = new ArrayList<>();
    }

    static class Edge{
        int weight;
        int dest;

        Edge(int d, int w){
            dest = d;
            weight = w;
        }
    }
}


