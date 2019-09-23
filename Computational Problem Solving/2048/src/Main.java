import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[][] board = new int[4][4];

        for(int y = 0; y < 4; y++){
            for(int x = 0; x < 4; x++){
                board[y][x] = in.nextInt();
            }
        }

        int move = in.nextInt();

        switch(move){
            case 0:
                moveLeft(board);
            case 1:
                moveUp(board);
            case 2:
                moveRight(board);
            case 3:
                moveDown(board);
        }
    }

    private static void moveRight(int[][] board) {
        int[][] result = new int[4][4];
        for(int i = 0; i < 4; i++){
            int[] row = slide(board[i]);
            int index = 0;
            for(int k = 3; k >= 0; k--){
                result[i][k] = row[index];
                index++;
            }
        }
    }

    private static void moveDown(int[][] board) {
        int[][] result = new int[4][4];
        for(int i = 0; i < 4; i++){
            int r[] =
        }
    }

    private static void moveUp(int[][] board) {

    }

    private static void moveLeft(int[][] board) {

    }

    private static int[] slide(int[] slice){
        int index = 0;
        int[] result = new int[4];

        for(int x = 0; x < 4; x++){
            if(slice[x] != 0){
                result[index] = slice[x];
                index++;
            }
        }

        for(int x = 0; x < 3; x++){
            if(result[x] == 0 || result[x] == result[x + 1]) {
                result[x] = result[x] + result[x + 1];
                result[x + 1] = 0;
            }
        }

        return result;
    }
}
