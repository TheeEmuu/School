import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AdjacencyMatrixGraph {
	private int data[][];
	private int size;
	private boolean directed;

//this is country music in code
	public AdjacencyMatrixGraph(int size, boolean dir) {
		this.size = size;
		directed = dir;
		data = new int[size][size];
	}

	public void addEdge(int start, int end) {
		addEdge(start, end, 1);
	}

	public void addEdge(int start, int end, int weight) {
		data[start][end] = weight;
		if (!directed)
			data[end][start] = weight;
	}

	public void removeEdge(int start, int end) {
		data[start][end] = 0;
		if (!directed)
			data[end][start] = 0;
	}

	public boolean containsEdge(int start, int end){
		return data[start][end] != 0;
	}

	public void printGraph() {
		System.out.print("  ");

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int row = 0; row < size; row++) {
			System.out.print(row + " ");

			for (int column = 0; column < size; column++) {
				System.out.print(data[row][column] + " ");
			}

			System.out.println();
		}
		System.out.println();
	}

	//Both methods are O(V) as we iterate over each edge to check if it's there
	//We could make it O(1) by keeping an additional number in each row and
	//column and incrementing them when we add an edge
	private int inDegree(int v) {
		int degree = 0;

		for(int i = 0; i < size; i++){
			if(data[i][v] != 0)
				degree++;
		}

		return degree;
	}

	private int outDegree(int v) {
		int degree = 0;

		for(int i = 0; i < size; i++){
			if(data[v][i] != 0)
				degree++;
		}

		return degree;
	}

	public boolean[] bfs(int u){
		boolean[] visited = new boolean[size];

		LinkedList<Integer> toVisit = new LinkedList<>();
		toVisit.push(u);

		while(!toVisit.isEmpty()){
			int cur = toVisit.pop();
			visited[cur] = true;

			for(int i = 0; i < size; i++){
				if(data[cur][i] != 0 && !visited[i])
					toVisit.push(i);
			}
		}

		return visited;
	}

	public ArrayList<Integer> toposort(){
		ArrayList<Integer> sort = new ArrayList<>(size);
		int[] indegree = new int[size];

		LinkedList<Integer> queue = new LinkedList<>();

		for(int i = 0; i < size; i++){
			indegree[i] = inDegree(i);
			if(indegree[i] == 0)
				queue.push(i);
		}

		while(!queue.isEmpty()){
			int cur = queue.pop();
			sort.add(cur);

			for(int i = 0; i < size; i++){
				if(data[cur][i] != 0){
					indegree[i] -= 1;
					if(indegree[i] == 0)
						queue.push(i);
				}
			}
		}

		return sort;
	}

	public void floyd(){
		for(int w = 0; w < size; w++){
			printGraph();
			for(int u = 0; u < size; u++){
				for(int v = 0; v < size; v++){
					if(containsEdge(u, w) && containsEdge(w, v)){
						int newDist = data[u][w] + data[w][v];

						if(containsEdge(u, v)){
							int acrossDist = data[u][v];

							if(newDist < acrossDist)
								data[u][v] = newDist;
						}
						else{
							addEdge(u, v, newDist);
						}
					}
				}
			}
		}
	}
}
