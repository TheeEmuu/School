import java.awt.geom.Point2D;
import java.util.*;

@SuppressWarnings("SuspiciousNameCombination")
public class Main {
    // https://open.kattis.com/problems/weirdflecksbutok
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

//        PriorityQueue<Flaw> flaws = new PriorityQueue<>(new Comparator<Flaw>() {
//            @Override
//            public int compare(Flaw flaw, Flaw t1) {
//                if(Math.random() > .5)
//                    return 1;
//                else
//                    return -1;
//            }
//        });
        ArrayList<Flaw> flaws = new ArrayList<>();
        for(int i = 0; i < size; i++){
            flaws.add(new Flaw(in.nextDouble(), in.nextDouble(), in.nextDouble()));
        }
        Collections.shuffle(flaws, new Random());

        System.out.println(Math.min(Math.min(xy(flaws), yz(flaws)), zx(flaws)));

//        Circle circle = new Circle(new Point(0, 2), new Point(0, 0));
//        System.out.println(circle.diameter());
    }

    public static double xy(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.x, flaw.y));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            circle.add(points.subList(0, i + 1), points.get(i));
        }

        return circle.diameter();
    }

    public static double yz(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.y, flaw.z));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            circle.add(points.subList(0, i + 1), points.get(i));
        }

        return circle.diameter();

    }

    public static double zx(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.z, flaw.x));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            circle.add(points.subList(0, i + 1), points.get(i));
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

        Circle(Point a){
            center = a;
            radius = 0;
        }

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

        Circle add(List<Point> points, Point add){
            if(!contains(add)){
                if(points.size() == 1){
                    return new Circle(points.get(0));
                }

                Circle best =
            }

            return this;
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
