public class Main {
    static class Location{
        int Missionaries, Cannibals;

        public Location(int miss, int cann){
            Missionaries = miss;
            Cannibals = cann;
        }

        public int[] occupants(){
            return new int[]{Missionaries, Cannibals};
        }
    }

    static class Boat{
        Location cur;

        public Boat(Location start){
            cur = start;
        }

        public Location currentLocation(){
            return cur;
        }
    }

    public static void main(String[] args){
        Location a = new Location(3, 3);
        Location b = new Location(0, 0);
    }
}
