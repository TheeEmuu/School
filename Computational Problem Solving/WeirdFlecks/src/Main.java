import java.awt.geom.Point2D;
import java.util.*;

public class Main {
    //https://open.kattis.com/problems/weirdflecksbutok
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        PriorityQueue<Flaw> flaws = new PriorityQueue<>(new Comparator<Flaw>() {
            @Override
            public int compare(Flaw flaw, Flaw t1) {
                if(Math.random() > .5)
                    return 1;
                else
                    return -1;
            }
        });
        for(int i = 0; i < size; i++){
            flaws.add(new Flaw(in.nextDouble(), in.nextDouble(), in.nextDouble()));
        }

        System.out.println(Math.min(Math.min(xy(new PriorityQueue<>(flaws)), yz(new PriorityQueue<>(flaws))), zx(new PriorityQueue<>(flaws))));

//        Circle circle = new Circle(new Point(0, 2), new Point(0, 0));
//        System.out.println(circle.diameter());
    }

    public static double xy(PriorityQueue<Flaw> flaws){
        Flaw flaw = flaws.poll();
        Point x = new Point(flaw.x, flaw.y);
        flaw = flaws.poll();
        Point y = new Point(flaw.x, flaw.y);
        Circle circle = new Circle(x, y);

        while(!flaws.isEmpty()){
            flaw = flaws.poll();
            Point add = new Point(flaw.x, flaw.y);
            circle.add(add);
        }

        return circle.diameter();
    }

    public static double yz(PriorityQueue<Flaw> flaws){
        Flaw flaw = flaws.poll();
        Point x = new Point(flaw.y, flaw.z);
        flaw = flaws.poll();
        Point y = new Point(flaw.y, flaw.z);
        Circle circle = new Circle(x, y);

        while(!flaws.isEmpty()){
            flaw = flaws.poll();
            Point add = new Point(flaw.y, flaw.z);
            circle.add(add);
        }

        return circle.diameter();

    }

    public static double zx(PriorityQueue<Flaw> flaws){
        Flaw flaw = flaws.poll();
        Point x = new Point(flaw.z, flaw.x);
        flaw = flaws.poll();
        Point y = new Point(flaw.z, flaw.x);
        Circle circle = new Circle(x, y);

        while(!flaws.isEmpty()){
            flaw = flaws.poll();
            Point add = new Point(flaw.z, flaw.x);
            circle.add(add);
        }

        return circle.diameter();
    }

    private static class Flaw {
        public double x, y, z;
        public Flaw(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Point{
        public double x, y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    static class Circle{
        Point center;
        double radius;
        Point[] points = new Point[3];
        Circle(Point a, Point b){
            center = new Point((a.x + b.x)/2, (a.y + b.y)/2);
            radius = Point2D.distance(a.x, a.y, center.x, center.y);
            points[0] = a;
            points[1] = b;
            points[2] = null;
        }

        Circle(Point a, Point b, Point c){
            points[0] = a;
            points[1] = b;
            points[2] = c;

            double d = 2 * (a.x * (b.y - c.y) + b.y * (c.y - a.y) + c.x * (a.y - b.y));

            double x = ((Math.pow(a.x, 2) + Math.pow(a.y, 2)) * (b.y - c.y) +
                        (Math.pow(b.x, 2) + Math.pow(b.y, 2)) * (c.y - a.y) +
                        (Math.pow(c.x, 2) + Math.pow(c.y, 2)) * (a.y - b.y))/d;
            double y = ((Math.pow(a.x, 2) + Math.pow(a.y, 2)) * (c.x - b.x) +
                        (Math.pow(b.x, 2) + Math.pow(b.y, 2)) * (a.x - c.x) +
                        (Math.pow(c.x, 2) + Math.pow(c.y, 2)) * (b.x - a.x))/d;

            center = new Point(x, y);
            radius = Point2D.distance(center.x, center.y, a.x, a.y);
        }

        boolean contains(Point x){
            return Point2D.distance(center.x, center.y, x.x, x.y) <= radius;
        }

        double diameter(){
            return radius * 2;
        }

        void add(Point add){
            if(!contains(add)){
                ArrayList<Circle> circles = new ArrayList<>();
                circles.add(new Circle(points[0], add));
                circles.add(new Circle(points[1], add));
                circles.add(new Circle(points[0], points[1], add));

                if(points[2] != null) {
                    circles.add(new Circle(points[2], add));
                    circles.add(new Circle(points[0], points[2], add));
                    circles.add(new Circle(points[1], points[2], add));
                }

                int bestCircle = -1;
                for(int i = 0; i < circles.size(); i++){
                    Circle circle = circles.get(i);

                    if(circle.contains(points[0]) &&
                            circle.contains(points[1]) &&
                            circle.contains(add) &&
                            !(points[2] != null && !circle.contains(points[2]))){
                        if(bestCircle == -1 || circle.radius < circles.get(bestCircle).radius){
                            bestCircle = i;
                        }
                    }
                }

                    Circle best = circles.get(bestCircle);
                    points[0] = best.points[0];
                    points[1] = best.points[1];
                    points[2] = best.points[2];
                    center = best.center;
                    radius = best.radius;

            }
        }
    }

//    private static class Circle{
//        double A,B,C,D;
//        Point center;
//        double radius;
//
//        Point[] points = new Point[3];
//        public double diameter(){
//            return radius * 2;
//        }
//
//        public boolean contains(Point point){
//            return Point2D.distance(center.x, center.y, point.x, point.y) <= radius;
//        }
//
//        Circle(Point a, Point b, Point c){
//            points[0] = a;
//            points[1] = b;
//            points[2] = c;
//            this.A = a.x *(b.y - c.y) - a.y *(b.x - c.x) + b.x * c.y - c.x * b.y;
//            double v = Math.pow(a.x, 2) + Math.pow(a.y, 2);
//            double v1 = Math.pow(b.x, 2) + Math.pow(b.y, 2);
//            double v2 = Math.pow(c.x, 2) + Math.pow(c.y, 2);
//            this.B = v * (c.y - b.y) +
//                    v1 * (a.y - c.y) +
//                    v2 * (b.y - a.y);
//            this.C = v * (b.x - c.x) +
//                    v1 * (c.x - a.x) +
//                    v2 * (a.x - b.x);
//            this.D = v * (c.x * b.y - b.x * c.y) +
//                    v1 * (a.x * c.y - c.x * a.y) +
//                    v2 * (b.x * a.y - a.x * b.y);
//
//            center = new Point(-B/(2*A), -C/(2*A));
//            radius = Math.sqrt((Math.pow(B, 2) + Math.pow(C, 2) - 4*A*D)/(4*Math.pow(A, 2)));
//        }
//
//        Circle(Point a, Point b){
//            points[0] = a;
//            points[1] = b;
//            center = new Point((a.x + b.x)/2 , (a.y + b.y)/2);
//            points[2] = center;
//            radius = Point2D.distance(center.x, center.y, a.x, a.y);
//        }
//
//        Circle add(Point x){
//            return null;
//        }
//    }
}
