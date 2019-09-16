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
        //x1 starts behind x2
        if((x1 < x2 && v1 > v2)){
            while(x1 < x2){
                x1 += v1;
                x2 += v2;

                if(x1 == x2)
                    return "YES";
            }
        }
        //x2 starts behind x1
        else if((x2 < x1 && v2 > v1)){
            while(x1 > x2){
                x1 += v1;
                x2 += v2;

                if(x1 == x2)
                    return "YES";
            }
        }

        return "NO";
    }
}
