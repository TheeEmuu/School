import java.lang.reflect.Array;
import java.util.*;

public class LatinSquares {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        master : while(in.hasNext()){
            int n = in.nextInt();
            in.nextLine();

            HashSet<Character> set = new HashSet<>();
            ArrayList<ArrayList<Character>> columns = new ArrayList<>();

            for(int i = 0; i < n; i++){
                String row = in.nextLine();

                ArrayList<Character> rows = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    set.add(row.charAt(j));
                    rows.add(row.charAt(j));
                }

                columns.add(rows);
            }

            if(set.size() > n){
                System.out.println("No");
                continue master;
            }

            //transpose columns
            ArrayList<ArrayList<Character>> c = new ArrayList<>();
            for(int i = 0; i < n; i++){
                ArrayList<Character> r = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    r.add(columns.get(j).get(i));
                }
                c.add(r);
            }

            //is it a Latin Square?
            for(int i = 0; i < n; i++){
                //check rows
                for(int j = 0; j < n; j++){
                    Character check = columns.get(i).get(j);
                    Character checkT = c.get(i).get(j);

                    if(columns.get(i).lastIndexOf(check) != j  || c.get(i).lastIndexOf(checkT) != j) {
                        System.out.println("No");
                        continue master;
                    }
                }
            }

            Object[] rR = columns.get(0).toArray();
            Object[] cR = c.get(0).toArray();

            Object[] rSort = columns.get(0).toArray();
            Object[] cSort = c.get(0).toArray();

            Arrays.sort(rSort);
            Arrays.sort(cSort);

            if(Arrays.equals(rR,rSort) && Arrays.equals(cR, cSort))
                System.out.println("Reduced");
            else
                System.out.println("Not Reduced");
        }
    }
}
