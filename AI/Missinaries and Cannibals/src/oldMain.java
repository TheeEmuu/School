public class oldMain {
    static class Location{
        int Missionaries, Cannibals;
        Boolean boat;

        public Location(int miss, int cann){
            Missionaries = miss;
            Cannibals = cann;
        }

        public int[] occupants(){
            return new int[]{Missionaries, Cannibals};
        }
    }

    public static void main(String[] args){
        Location a = new Location(3, 3);
        Location b = new Location(0, 0);
    }
}
