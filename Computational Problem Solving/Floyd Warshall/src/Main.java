import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[][] graph = new int[N][N];
        int[][] pred = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int k = 0; k < N; k++){
                graph[i][k] = -1;
                pred[i][k] = -1;
            }
            graph[i][i] = 0;
            pred[i][i] = i;
        }

        int M = in.nextInt();
        for(int i = 0; i < M; i++){
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph[u][v] = w;
        }

        // Floyd-Warshall

        for(int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++){
                    if(graph[i][k] != -1 && graph[k][j] != -1){
                        if(graph[i][j] == -1 || graph[i][j] > graph[i][k] + graph[k][j]){
                            graph[i][j] = graph[i][k] + graph[k][j];
                            pred[i][j] = pred[k][j];
                        }
                    }
                }
            }
        }

        for(int[] x : graph){
            for(int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
