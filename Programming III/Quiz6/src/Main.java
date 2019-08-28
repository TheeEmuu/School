public class Main {
	public static void main(String[] args){
		AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5, false);

//		graph.addEdge(1, 2);
//		graph.addEdge(2, 4);
//		graph.addEdge(0, 3);
//		graph.addEdge(1, 3);
//		graph.addEdge(2, 3);
//		graph.addEdge(3, 4);

		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);

		AdjacencyMatrixGraph reverse = graph.reverse();

		System.out.println(graph.isStronglyConnected());
		graph.printGraph();

		reverse.printGraph();
	}
}
