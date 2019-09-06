import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class GraphFromFile {
    public static void main(String[] args) {


        try {
            File file = new File("D:\\Programming\\School SVN\\ejj001\\Mar 29\\src\\graphdata");
            Scanner in = new Scanner(file);

            int verticies = in.nextInt();
            int edges = in.nextInt();
            in.nextLine();

            AdjacencyListGraph graph = new AdjacencyListGraph(verticies, true);

            for(int i = 0; i < edges; i++){
                graph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
                in.nextLine();
            }

            in = new Scanner(System.in);
            System.out.print("Please insert a node number: ");
            int vertex = in.nextInt();

            Iterator it = graph.neighbors(vertex);
            while(it.hasNext()){
                System.out.print(it.next());
            }
        }
        catch(Exception e){ System.out.println(e); }
    }
}
