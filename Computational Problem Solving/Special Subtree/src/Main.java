import java.util.ArrayList;
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
