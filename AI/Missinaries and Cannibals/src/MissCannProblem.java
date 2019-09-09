import aima.core.search.framework.problem.Problem;

import java.util.ArrayList;
import java.util.List;

public class MissCannProblem implements Problem<State, Action> {
    public MissCannProblem(){

    }

    @Override
    public State getInitialState() {
        return new State(3, 3, 0, 0, 1);
    }

    @Override
    public List<Action> getActions(State state) {
        List<Action> list = new ArrayList<>();

        switch (state.getBoat()){
            case 1:
                switch (state.getMissionariesA()){
                    case 3:
                    case 2:
                        switch(state.getCannibalsA()){
                            case 3:
                            case 2:
                            case 1:
                            case 0:
                                if(state.getMissionariesB() + 2 >= state.getCannibalsB())
                                    list.add(new Action(2, 0));
                        }
                    case 1:
                        switch(state.getCannibalsA()){
                            case 3:
                            case 2:
                            case 1:
                                if(state.getMissionariesB() + 1 >= state.getCannibalsB() + 1)
                                    list.add(new Action(1, 1));
                            case 0:
                                if(state.getMissionariesB() + 1 >= state.getCannibalsB())
                                    list.add(new Action(1, 0));
                        }
                    case 0:
                        switch (state.getCannibalsA()){
                            case 3:
                            case 2:
                                if(state.getMissionariesB() >= state.getCannibalsB() + 2)
                                    list.add(new Action(0, 2));
                            case 1:
                                if(state.getMissionariesB() >= state.getCannibalsB() + 1)
                                    list.add(new Action(0, 1));
                            case 0:
                                break;
                        }
                }
                break;
            case 2:
                switch (state.getMissionariesB()){
                    case 3:
                    case 2:
                        switch(state.getCannibalsB()){
                            case 3:
                            case 2:
                            case 1:
                            case 0:
                                if(state.getMissionariesA() + 2 >= state.getCannibalsA())
                                    list.add(new Action(2, 0));
                        }
                    case 1:
                        switch(state.getCannibalsB()){
                            case 3:
                            case 2:
                            case 1:
                                if(state.getMissionariesA() + 1 >= state.getCannibalsA() + 1)
                                    list.add(new Action(1, 1));
                            case 0:
                                if(state.getMissionariesA() + 1 >= state.getCannibalsA())
                                    list.add(new Action(1, 0));
                        }
                    case 0:
                        switch (state.getCannibalsB()){
                            case 3:
                            case 2:
                                if(state.getMissionariesA() >= state.getCannibalsA() + 2)
                                    list.add(new Action(0, 2));
                            case 1:
                                if(state.getMissionariesA() >= state.getCannibalsA() + 1)
                                    list.add(new Action(0, 1));
                            case 0:
                                break;
                        }
                }
                break;
        }

        return list;
    }

    @Override
    public State getResult(State state, Action action) {
        return action.move(state);
    }

    @Override
    public boolean testGoal(State state) {
        return state.getCannibalsB() == 3 && state.getMissionariesB() == 3;
    }

    @Override
    public double getStepCosts(State state, Action action, State stateDelta) {
        return 0;
    }
}
