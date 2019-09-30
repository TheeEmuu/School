import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int numMinions = in.nextInt();

        ArrayList<Minion> minions = new ArrayList<>();
        for(int i = 0; i < numMinions; i++){
            minions.add(new Minion(in.nextInt(), in.nextInt()));
        }

        minions.sort(new SortMinion());

//        System.out.println();
//        for(Minion x : minions){
//            System.out.println(x.getMinTemp() + " " + x.getMaxTemp());
//        }

        int rooms = 0;
        int lowestTemp = -1;

        for(int i = 0; i < numMinions; i++){
            if(minions.get(i).getMinTemp() > lowestTemp){
                rooms++;
                lowestTemp = minions.get(i).getMaxTemp();
            }
        }

        System.out.println(rooms);
    }
}

class Minion{
    private int maxTemp, minTemp;

    public Minion(int min, int max){
        minTemp = min;
        maxTemp = max;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }
}

class SortMinion implements Comparator<Minion>{
    @Override
    public int compare(Minion o1, Minion o2) {
        if(o1.getMaxTemp() == o2.getMaxTemp())
            return o1.getMinTemp() - o2.getMinTemp();
        else
            return o1.getMaxTemp() - o2.getMaxTemp();
    }
}
