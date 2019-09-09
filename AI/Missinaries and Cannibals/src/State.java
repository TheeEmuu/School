public class State {
    private int missionariesA, missionariesB;
    private int cannibalsA, cannibalsB;
    private int boat;

    public State(int mA, int cA, int mB, int cB, int b){
        missionariesA = mA;
        cannibalsA = cA;
        missionariesB = mB;
        cannibalsB = cB;
        boat = b; //1 is a, 2 is b
    }

    public State(State state){
        missionariesA = state.getMissionariesA();
        missionariesB = state.getMissionariesB();
        cannibalsA = state.getCannibalsA();
        cannibalsB = state.getCannibalsB();
        boat = getBoat();
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
        return missionariesB;
    }

    public void setMissionariesB(int missionariesB) {
        this.missionariesB = missionariesB;
    }

    public int getCannibalsA() {
        return cannibalsA;
    }

    public void setCannibalsA(int cannibalsA) {
        this.cannibalsA = cannibalsA;
    }

    public int getCannibalsB() {
        return cannibalsB;
    }

    public void setCannibalsB(int cannibalsB) {
        this.cannibalsB = cannibalsB;
    }
}
