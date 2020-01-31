import java.awt.geom.Point2D;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        ArrayList<Flaw> flaws = new ArrayList<>();
        for(int i = 0; i < size; i++){
            flaws.add(new Flaw(in.nextDouble(), in.nextDouble(), in.nextDouble()));
        }
        //Collections.shuffle(flaws, new Random());

        System.out.println(Math.min(Math.min(xy(flaws), yz(flaws)), zx(flaws)));
    }

    public static double xy(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.x, flaw.y));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            if(!circle.contains(points.get(i))) {
                circle = makeCircleOne(points.subList(0, i + 1), points.get(i));
            }
        }

        return circle.radius * 2;
    }

    public static double yz(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.y, flaw.z));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            if(!circle.contains(points.get(i))) {
                circle = makeCircleOne(points.subList(0, i + 1), points.get(i));
            }
        }

        return circle.radius * 2;
    }

    public static double zx(List<Flaw> flaws){
        ArrayList<Point> points = new ArrayList<>();
        for(Flaw flaw : flaws){
            points.add(new Point(flaw.z, flaw.x));
        }
        Circle circle = new Circle(points.get(0), points.get(1));

        for(int i = 2; i < flaws.size(); i++){
            if(!circle.contains(points.get(i))) {
                circle = makeCircleOne(points.subList(0, i + 1), points.get(i));
            }
        }

        return circle.radius * 2;
    }

    public static Circle makeCircleOne(List<Point> points, Point a){
        Circle c = new Circle(a, 0);
        for(int i = 0; i < points.size(); i++){
            Point b = points.get(i);
            if(!c.contains(b)){
                if(c.radius == 0)
                    c = new Circle(a, b);
                else
                    c = makeCircleTwo(points.subList(0, i + 1), a, b);
            }
        }

        return c;
    }

    public static Circle makeCircleTwo(List<Point> points, Point a, Point b){
        Circle circ = new Circle(a, b);
        Circle left = null;
        Circle right = null;

        Point ab = a.subtract(b);
        for(Point p : points){
            if(circ.contains(p))
                continue;

            double cross = ab.cross(p.subtract(a));
            Circle c = makeCircumcircle(a, b, p);
            if(c == null)
                continue;
            else if (cross > 0 && (left == null || ab.cross(c.center.subtract(a)) > ab.cross(left.center.subtract(a))))
                left = c;
            else if (cross < 0 && (right == null || ab.cross(c.center.subtract(a)) < ab.cross(right.center.subtract(a))))
                right = c;
        }

        if (left == null && right == null)
            return circ;
        else if(left == null)
            return right;
        else if (right == null)
            return left;
        else if (left.radius <= right.radius)
            return left;
        else
            return right;
    }

    public static Circle makeCircumcircle(Point a, Point b, Point c){

//        double d = 2 * (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y));
//        if (d == 0)
//            return null;
//
//        double x = ((Math.pow(a.x, 2) + Math.pow(a.y, 2)) * (b.y - c.y) +
//                (Math.pow(b.x, 2) + Math.pow(b.y, 2)) * (c.y - a.y) +
//                (Math.pow(c.x, 2) + Math.pow(c.y, 2)) * (a.y - b.y))/d;
//        double y = ((Math.pow(a.x, 2) + Math.pow(a.y, 2)) * (c.x - b.x) +
//                (Math.pow(b.x, 2) + Math.pow(b.y, 2)) * (a.x - c.x) +
//                (Math.pow(c.x, 2) + Math.pow(c.y, 2)) * (b.x - a.x))/d;
//
//        Point center = new Point(x, y);
//        double radius = Math.max(Math.max(center.distance(a), center.distance(b)), center.distance(c));
//        return new Circle(center, radius);
        double ox = (Math.min(Math.min(a.x, b.x), c.x) + Math.max(Math.min(a.x, b.x), c.x)) / 2;
        double oy = (Math.min(Math.min(a.y, b.y), c.y) + Math.max(Math.min(a.y, b.y), c.y)) / 2;
        double ax = a.x - ox,  ay = a.y - oy;
        double bx = b.x - ox,  by = b.y - oy;
        double cx = c.x - ox,  cy = c.y - oy;
        double d = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) * 2;
        if (d == 0)
            return null;
        double x = ((ax*ax + ay*ay) * (by - cy) + (bx*bx + by*by) * (cy - ay) + (cx*cx + cy*cy) * (ay - by)) / d;
        double y = ((ax*ax + ay*ay) * (cx - bx) + (bx*bx + by*by) * (ax - cx) + (cx*cx + cy*cy) * (bx - ax)) / d;
        Point p = new Point(ox + x, oy + y);
        double r = Math.max(Math.max(p.distance(a), p.distance(b)), p.distance(c));
        return new Circle(p, r);
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

        public double distance(Point other){
            return Point2D.distance(x, y, other.x, other.y);
        }

        public Point subtract(Point p){
            return new Point(x - p.x, y - p.y);
        }

        public double cross(Point p){
            return x * p.y - y * p.x;
        }
    }

    private static class Circle{
        Point center;
        double radius;

        public Circle(Point center, double radius){
            this.center = center;
            this.radius = radius;
        }

        public Circle(Point a, Point b){
            this.center = new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
            this.radius = center.distance(a);
        }

        public boolean contains(Point add){
            return center.distance(add) <= radius;
        }

        public boolean contains(List<Point> points){
            for(Point add : points){
                if(!contains(add))
                    return false;
            }
            return true;
        }
    }
}
