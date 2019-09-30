import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Location gopherLocation = new Location(in.nextDouble(), in.nextDouble());
        Location dogLocation = new Location(in.nextDouble(), in.nextDouble());

        ArrayList<Location> holes = new ArrayList<>();
        while(in.hasNext()){
            holes.add(new Location(in.nextDouble(), in.nextDouble()));
        }

        boolean escape = false;
        String answer = "";
        for (Location hole : holes) {
            double gophDist = Point2D.distance(gopherLocation.getX(), gopherLocation.getY(), hole.getX(), hole.getY());
            double dogDist = Point2D.distance(dogLocation.getX(), dogLocation.getY(), hole.getX(), hole.getY()) / 2;

            if(gophDist <= dogDist){
                answer = "The gopher can escape through the hole at (" + String.format("%.3f", hole.getX()) + "," + String.format("%.3f", hole.getY()) + ").";
                escape = true;
                break;
            }
        }

        if(!escape)
            answer = "The gopher cannot escape.";

        System.out.println(answer);
    }
}

class Location{
    private double x, y;

    public Location(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
