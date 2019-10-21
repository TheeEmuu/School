import java.util.Scanner;

public class Main {
    public static void Main(String[] args){
        Scanner in = new Scanner(System.in);

        int routes = in.nextInt();

        for(int c = 0; c < routes; c++){
            int distance = in.nextInt();
            Point cur = new Point(0, 0);
            for(int i = 0; i < distance; i++){

            }
        }
    }

    private static class Point{
        int x,y;
        int[] connectedPoints;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }



        Point north(Point cur){
            Point next = new Point(x, y + 1);
            connectedPoints
            return
        }
        Point south(Point cur){
            return new Point(x, y - 1);
        }
        Point east(Point cur){
            return new Point(x + 1, y);
        }
        Point west(Point cur){
            return new Point(x - 1, y);
        }
    }
}


