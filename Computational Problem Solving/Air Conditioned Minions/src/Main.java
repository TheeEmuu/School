//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Main {
//    // https://open.kattis.com/problems/airconditioned
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//
//        int numMinions = in.nextInt();
//
//        ArrayList<Minion> minions = new ArrayList<>();
//        for(int i = 0; i < numMinions; i++){
//            minions.add(new Minion(in.nextInt(), in.nextInt()));
//        }
//
//        HashMap<Integer, ArrayList<Minion>> grid = new HashMap<>();
//
//        int totalMin = minions.get(0).getMinTemp();
//        int totalMax = minions.get(0).getMaxTemp();
//
//        for(Minion x : minions){
//            if(x.getMinTemp() < totalMin)
//                totalMin = x.getMinTemp();
//            if(x.getMaxTemp() > totalMax)
//                totalMax = x.getMaxTemp();
//
//            for(int i = x.getMinTemp(); i < x.getMaxTemp(); i++){
//                grid.putIfAbsent(i, new ArrayList<>());
//                grid.get(i).add(x);
//            }
//        }
//
//        int rooms = 0;
//        while(!empty(grid, totalMin, totalMax)) {
//            int currentMode = -1;
//            int index = -1;
//            for (int i = totalMin; i < totalMax; i++) {
//                if(currentMode < grid.get(i).size()) {
//                    currentMode = grid.get(i).size();
//                    index = i;
//                }
//            }
//
//            ArrayList<Minion> toRemove = new ArrayList<>(grid.get(index));
//            for(Minion x : toRemove){
//                for(int i = totalMin; i < totalMax; i++){
//                    grid.get(i).remove(x);
//                }
//            }
//
//            rooms++;
//        }
//
//        System.out.println(rooms);
//    }
//
//    private static boolean empty(HashMap<Integer, ArrayList<Minion>> grid, int min, int max){
//        for(int i = min; i < max; i++){
//            if(!grid.get(i).isEmpty())
//                return false;
//        }
//        return true;
//    }
//}
//
//class Minion{
//    int maxTemp, minTemp;
//
//    public Minion(int min, int max){
//        minTemp = min;
//        maxTemp = max + 1;
//    }
//
//    public int getMaxTemp() {
//        return maxTemp;
//    }
//
//    public int getMinTemp() {
//        return minTemp;
//    }
//}
