import java.util.Scanner;

public class Main {
    static int x1, x2;
    static int v1, v2;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        x1 = in.nextInt();
        v1 = in.nextInt();
        x2 = in.nextInt();
        v2 = in.nextInt();

        System.out.println(Kangaroo(x1, v1, x2, v2));
    }

    public static String Kangaroo(int x1, int v1, int x2, int v2){
        int x, v;

        if(v1  > v2) {
            x = x2 - x1;
            v = v1 - v2;
        }
        else {
            x = x1 - x2;
            v = v2 - v1;
        }

        double r = x / v;
        System.out.println(r);
        if(r == (int)r && r > 0)
            return "YES";
        else
            return "NO";
    }
}
