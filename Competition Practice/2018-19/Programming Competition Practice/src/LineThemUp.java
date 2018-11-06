import java.util.Scanner;
import java.util.Vector;

public class LineThemUp {
    private static boolean isAscending(Vector<String> a){
        for(int i = 0; i < a.size() - 1; i++){
            if(a.get(i).charAt(0) <= a.get(i+1).charAt(0)){}
            else return false;
        }

        return true;
    }
    private static boolean isDecending(Vector<String> a){
        for(int i = 0; i < a.size() - 1; i++){
            if(a.get(i).charAt(0) >= a.get(i+1).charAt(0)){}
            else return false;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        input.useDelimiter("");

        while(input.hasNextLine()){
            int iterations = 0;
            try{
                iterations = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                break;
            }

            Vector team = new Vector();

            for(int i = 0; i < iterations; i++){
                team.add(input.nextLine());
            }

            if(isAscending(team))
                System.out.println("INCREASING");
            else if(isDecending(team))
                System.out.println("DECREASING");
            else
                System.out.println("NEITHER");
        }
    }
}