import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    //https://open.kattis.com/problems/weirdflecksbutok
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        int size = in.nextInt();
//
//        PriorityQueue<Flaw> flaws = new PriorityQueue<>(new Comparator<Flaw>() {
//            @Override
//            public int compare(Flaw flaw, Flaw t1) {
//                if(Math.random() > .5)
//                    return 1;
//                else
//                    return -1;
//            }
//        });
//        for(int i = 0; i < size; i++){
//            flaws.add(new Flaw(in.nextDouble(), in.nextDouble(), in.nextDouble()));
//        }
//
//        System.out.println(Math.min(Math.min(xy(flaws), yz(flaws)), zx(flaws)));

        Circle circle = new Circle(new Point(-3, 4), new Point(4, 5), new Point(1, -4));
        System.out.println(circle.diameter());
    }

    public static double xy(PriorityQueue<Flaw> flaws){
        return -1;
    }

    public static double yz(PriorityQueue<Flaw> flaws){
        return -1;
    }

    public static double zx(PriorityQueue<Flaw> flaws){
        return -1;
    }

    public static double welzl(PriorityQueue<Flaw> flaws, Circle r){
        if(flaws.isEmpty())
            return r.diameter();
        Flaw flaw = flaws.poll();
        return -1;
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

    private static class Circle{
        double A,B,C,D;
        Point center;
        double radius;

        public double diameter(){
            return radius * 2;
        }

        public boolean isIn(Point point){
            return Math.sqrt(Math.pow(center.x - point.x, 2) + Math.pow(center.y - point.y, 2)) <= radius;
        }

        Circle(Point a, Point b, Point c){
            this.A = a.x *(b.y - c.y) - a.y *(b.x - c.x) + b.x * c.y - c.x * b.y;
            double v = Math.pow(a.x, 2) + Math.pow(a.y, 2);
            double v1 = Math.pow(b.x, 2) + Math.pow(b.y, 2);
            double v2 = Math.pow(c.x, 2) + Math.pow(c.y, 2);
            this.B = v * (c.y - b.y) +
                    v1 * (a.y - c.y) +
                    v2 * (b.y - a.y);
            this.C = v * (b.x - c.x) +
                    v1 * (c.x - a.x) +
                    v2 * (a.x - b.x);
            this.D = v * (c.x * b.y - b.x * c.y) +
                    v1 * (a.x * c.y - c.x * a.y) +
                    v2 * (b.x * a.y - a.x * b.y);

            center = new Point(-B/(2*A), -C/(2*A));
            radius = Math.sqrt((Math.pow(B, 2) + Math.pow(C, 2) - 4*A*D)/(4*Math.pow(A, 2)));
        }
    }
}
