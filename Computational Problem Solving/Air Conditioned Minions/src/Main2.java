import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int numMinions = in.nextInt();

        ArrayList<Minion> minions = new ArrayList<>();
        for(int i = 0; i < numMinions; i++){
            minions.add(new Minion(in.nextInt(), in.nextInt()));
        }

        Collections.sort(minions);

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

class Minion implements Comparable<Minion>{
    private int maxTemp, minTemp;

    public Minion(int min, int max){
        minTemp = min;
        maxTemp = max + 1;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    @Override
    public int compareTo(Minion o) {
        return this.getMinTemp() - o.getMinTemp();
    }
}
