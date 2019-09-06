import java.util.Scanner;

public class Quiz {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();

		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(n, false);

		for(int i = 0; i < m; i++){
			graph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
			in.nextLine();
		}

		graph.floyd();

		System.out.println(graph.maxDistance());
	}
}
