import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ALGraph graph = new ALGraph(7, true);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 4);
        graph.addEdge(0, 6, 8);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(1, 5, 6);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 6, 3);
        graph.addEdge(3, 4, 5);
        graph.addEdge(4, 5, 1);
        graph.addEdge(4, 6, 2);

        ALGraph.ShortPaths sp = graph.dijkstra(0);
        System.out.println(Arrays.toString(sp.dist));
        System.out.println(Arrays.toString(sp.pred));

        System.out.println();

        System.out.println(Arrays.toString(graph.shortestPath()));

//        int[] ar = new int[]{1,3,6,5,4,2};
//
//        System.out.println(ALGraph.firstHeap(ar, 6));
   }
}
