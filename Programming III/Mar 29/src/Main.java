public class Main {
	public static void main(String[] args){
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, true);

		graph.addEdge(0, 1, 1);
		graph.addEdge(0, 2, 11);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 4, 7);
		graph.addEdge(3, 1, 3);
		graph.addEdge(3, 2, 1);
		graph.addEdge(3, 4, 5);
		graph.addEdge(4, 0, 1);
		graph.addEdge(4, 1, 3);
		graph.addEdge(4, 2, 1);

		graph.floyd();
	}
}
