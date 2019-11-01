import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/torque-and-development/problem
public class Main {
    static Vertex[] nodes;

    public static void main(String[] args){
        try {
            Scanner in = new Scanner(new File("D:\\Programming\\school\\Computational Problem Solving\\Roads and Libraries\\src\\input08.txt" ));

            int queries = in.nextInt();
            while (queries-- > 0) {
                int vertices = in.nextInt();
                int edges = in.nextInt();
                long costLib = in.nextInt();
                long costRoad = in.nextInt();
                long cost = 0;

                if (costRoad < costLib) {
                    nodes = new Vertex[vertices];
                    for (int i = 0; i < vertices; i++) {
                        nodes[i] = new Vertex();
                    }
                    for (int i = 0; i < edges; i++) {
                        int origin = in.nextInt() - 1;
                        int dest = in.nextInt() - 1;
                        nodes[origin].edges.add(dest);
                    }

                    boolean[] visited = new boolean[vertices];
                    int distinct = 0;
                    for (int i = 0; i < vertices; i++) {
                        if (!visited[i]) {
                            dfs(i, visited);
                            distinct++;
                        }
                    }

                    cost = (distinct * costLib) + (vertices - distinct) * costRoad;
                } else {
                    cost = vertices * costLib;
                }

                System.out.println(cost);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static boolean[] dfs(int node, boolean[] visited){
        if (visited[node])
            return visited;
        visited[node] = true;
        for(int a : nodes[node].edges){
            dfs(a, visited);
        }
        return visited;
    }

    static class Vertex{
        ArrayList<Integer> edges = new ArrayList<>();
    }
}
