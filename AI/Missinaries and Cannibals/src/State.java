public class State {
    private int missionariesA, totalMissionaries;
    private int cannibalsA , totalCannibals;
    private int boat;

    public State(int mA, int cA, int b){
        missionariesA = mA;
        totalMissionaries = mA;
        cannibalsA = cA;
        totalCannibals = cA;
        boat = b; //1 is a, 2 is b
    }

    public State(State state){
        this(state.getMissionariesA(), state.getCannibalsA(), state.getBoat());
    }

    public int getBoat() {
        return boat;
    }

    public void setBoat(int boat) {
        this.boat = boat;
    }


    public int getMissionariesA() {
        return missionariesA;
    }

    public void setMissionariesA(int missionariesA) {
        this.missionariesA = missionariesA;
    }

    public int getMissionariesB() {
        return totalMissionaries - missionariesA;
    }

    public void setMissionariesB(int missionariesB) {
        this.missionariesA -= missionariesB;
    }

    public int getCannibalsA() {
        return cannibalsA;
    }

    public void setCannibalsA(int cannibalsA) {
        this.cannibalsA = cannibalsA;
    }

    public int getCannibalsB() {
        return totalCannibals - cannibalsA;
    }

    public void setCannibalsB(int cannibalsB) {
        this.cannibalsA -= cannibalsB;
    }
}
