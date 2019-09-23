public class Action {
    private int missionariesMoving, cannibalsMoving;

    public Action(int m, int c){
        missionariesMoving = m;
        cannibalsMoving = c;
    }

    public State move(State s){
        State state = new State(s);

        switch(state.getBoat()){
            case 1:
                state.setBoat(2);
                state.setMissionariesB(state.getMissionariesB() + missionariesMoving);
                state.setCannibalsB(state.getCannibalsB() + cannibalsMoving);
                break;
            case 2:
                state.setBoat(1);
                state.setMissionariesA(state.getMissionariesA() + missionariesMoving);
                state.setCannibalsA(state.getCannibalsA() + cannibalsMoving);
                break;
        }

        return state;
    }

    public int getMissionariesMoving() {
        return missionariesMoving;
    }

    public int getCannibalsMoving() {
        return cannibalsMoving;
    }
}
