import java.util.Scanner;

public class Main {
    //https://open.kattis.com/problems/weirdflecksbutok
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        Flaw[] flaws = new Flaw[size];
        for(int i = 0; i < size; i++){
            flaws[i] = new Flaw(in.nextDouble(), in.nextDouble(), in.nextDouble());
        }

        System.out.println(Math.min(Math.min(xy(flaws), yz(flaws)), zx(flaws)));
    }

    public static double xy(Flaw[] flaws){

    }

    public static double yz(Flaw[] flaws){

    }

    public static double zx(Flaw[] flaws){

    }

    public static sed()

    private static class Flaw {
        public double x, y, z;
        public Flaw(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
