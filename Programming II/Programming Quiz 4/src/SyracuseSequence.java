import java.util.Scanner;

public class SyracuseSequence {
    public static int syracuse(int n){
        if(n == 1)
            return 1;

        System.out.println(n);

        if(n % 2 !=0){
            syracuse(3*n + 1);
        }
        if(n % 2 == 0){
            syracuse(n/2);
        }

        return 1;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a starting value: ");
        int a = input.nextInt();

        System.out.printf("Syracuse sequence of %d \n", a);
        System.out.println(syracuse(a));
    }
}
