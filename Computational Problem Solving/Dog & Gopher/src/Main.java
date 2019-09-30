import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // https://open.kattis.com/problems/doggopher
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        Location gopherLocation = new Location(in.nextDouble(), in.nextDouble());
        Location dogLocation = new Location(in.nextDouble(), in.nextDouble());

        ArrayList<Location> holes = new ArrayList<>();
        while(in.hasNext()){
            holes.add(new Location(in.nextDouble(), in.nextDouble()));
        }

        double bestDist = Point2D.distance(gopherLocation.getX(), gopherLocation.getY(), holes.get(0).getX(), holes.get(0).getY());
        ArrayList<Location> bestHoles = new ArrayList<>();
        bestHoles.add(holes.get(0));
        for(Location hole : holes){
            double dist = Math.abs(Point2D.distance(gopherLocation.getX(), gopherLocation.getY(), hole.getX(), hole.getY()));
            if(dist < bestDist){
                bestDist = dist;
                bestHoles.clear();
                bestHoles.add(hole);
            }
            else if(dist == bestDist){
                bestHoles.add(hole);
            }
        }

        boolean escape = false;
        String answer = "";
        for(Location hole : bestHoles){
            double dogDist = Math.abs(Point2D.distance(dogLocation.getX(), dogLocation.getY(), hole.getX(), hole.getY())) / 2.0;
            if(dogDist >= bestDist){
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

//class Location{
//    private double x, y;
//
//    public Location(double x, double y){
//        this.x = x;
//        this.y = y;
//    }
//
//    public double getX() {
//        return x;
//    }
//
//    public double getY() {
//        return y;
//    }
//
//    @Override
//    public String toString() {
//        return x + ", " + y;
//    }
//}
