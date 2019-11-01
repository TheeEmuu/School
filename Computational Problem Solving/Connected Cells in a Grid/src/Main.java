import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem
public class Main {
    static int rows;
    static int columns;

    static int[][] grid;

    static final int[] dx = {-1,  0,  1, -1, 1, -1, 0, 1};
    static final int[] dy = {-1, -1, -1,  0, 0,  1, 1, 1};

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        rows = in.nextInt();
        columns = in.nextInt();
        grid = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            for(int k = 0; k < columns; k++){
                grid[i][k] = in.nextInt();
            }
        }

        int replacement = 2;
        for(int i = 0; i < rows; i++){
            for(int k = 0; k < columns; k++){
                if(grid[i][k] == 1){
                    dfs(i, k, replacement);
                    replacement++;
                }
            }
        }

        int[] sizes = new int[replacement - 1];
        for(int i = 0; i < rows; i++){
            for(int k = 0; k < columns; k++){
                if(grid[i][k] != 0){
                    sizes[grid[i][k] - 1]++;
                }
            }
        }

        int max = -1;
        for(int x : sizes){
            if(x > max)
                max = x;
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int replacement){
        if(x < 0 || x >= rows || y < 0 || y >= columns)
            return;
        if(grid[x][y] == 0 || grid[x][y] == replacement)
            return;

        grid[x][y] = replacement;

        dfs(x+dx[0], y+dy[0], replacement);
        dfs(x+dx[1], y+dy[1], replacement);
        dfs(x+dx[2], y+dy[2], replacement);
        dfs(x+dx[3], y+dy[3], replacement);
        dfs(x+dx[4], y+dy[4], replacement);
        dfs(x+dx[5], y+dy[5], replacement);
        dfs(x+dx[6], y+dy[6], replacement);
        dfs(x+dx[7], y+dy[7], replacement);
    }
}
