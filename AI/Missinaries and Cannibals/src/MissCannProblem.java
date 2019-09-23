import aima.core.search.framework.problem.Problem;
import aima.core.search.uninformed.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MissCannProblem implements Problem<State, Action> {
    public static void main(String[] args){
        BreadthFirstSearch<State, Action> search = new BreadthFirstSearch<>();

        Optional<List<Action>> acts = search.findActions(new MissCannProblem());

        if(acts.isPresent()) {
            for (Action x : acts.get())
                System.out.println(x);
        }
        else
            System.out.println("fail");
    }

    @Override
    public State getInitialState() {
        return new State(3, 3, 1);
    }

    @Override
    public List<Action> getActions(State state) {
        List<Action> list = new ArrayList<>();

        if(state.getBoat() == 1) {
            for (int miss = 0; miss < state.getMissionariesA(); miss++) {
                for (int cann = 0; cann < state.getCannibalsA(); cann++) {
                    Action act = getAction(list, miss, cann);

                    if (act != null)
                        list.add(act);
                }
            }
        }
        else{
            for (int miss = 0; miss < state.getMissionariesB(); miss++) {
                for (int cann = 0; cann < state.getCannibalsB(); cann++) {
                    Action act = getAction(list, miss, cann);

                    if (act != null)
                        list.add(act);
                }
            }
        }
//        switch (state.getBoat()){
//            case 1:
//                switch (state.getMissionariesA()){
//                    case 3:
//                    case 2:
//                        switch(state.getCannibalsA()){
//                            case 3:
//                            case 2:
//                            case 1:
//                            case 0:
//                                if(state.getMissionariesB() + 2 >= state.getCannibalsB())
//                                    list.add(new Action(2, 0));
//                        }
//                    case 1:
//                        switch(state.getCannibalsA()){
//                            case 3:
//                            case 2:
//                            case 1:
//                                if(state.getMissionariesB() + 1 >= state.getCannibalsB() + 1)
//                                    list.add(new Action(1, 1));
//                            case 0:
//                                if(state.getMissionariesB() + 1 >= state.getCannibalsB())
//                                    list.add(new Action(1, 0));
//                        }
//                    case 0:
//                        switch (state.getCannibalsA()){
//                            case 3:
//                            case 2:
//                                if(state.getMissionariesB() >= state.getCannibalsB() + 2)
//                                    list.add(new Action(0, 2));
//                            case 1:
//                                if(state.getMissionariesB() >= state.getCannibalsB() + 1)
//                                    list.add(new Action(0, 1));
//                            case 0:
//                                break;
//                        }
//                }
//                break;
//            case 2:
//                switch (state.getMissionariesB()){
//                    case 3:
//                    case 2:
//                        switch(state.getCannibalsB()){
//                            case 3:
//                            case 2:
//                            case 1:
//                            case 0:
//                                if(state.getMissionariesA() + 2 >= state.getCannibalsA())
//                                    list.add(new Action(2, 0));
//                        }
//                    case 1:
//                        switch(state.getCannibalsB()){
//                            case 3:
//                            case 2:
//                            case 1:
//                                if(state.getMissionariesA() + 1 >= state.getCannibalsA() + 1)
//                                    list.add(new Action(1, 1));
//                            case 0:
//                                if(state.getMissionariesA() + 1 >= state.getCannibalsA())
//                                    list.add(new Action(1, 0));
//                        }
//                    case 0:
//                        switch (state.getCannibalsB()){
//                            case 3:
//                            case 2:
//                                if(state.getMissionariesA() >= state.getCannibalsA() + 2)
//                                    list.add(new Action(0, 2));
//                            case 1:
//                                if(state.getMissionariesA() >= state.getCannibalsA() + 1)
//                                    list.add(new Action(0, 1));
//                            case 0:
//                                break;
//                        }
//                }
//                break;
//        }

        return list;
    }

    private Action getAction(List<Action> list, int miss, int cann){
        if(miss + cann <= 2) {
            Action act = new Action(miss, cann);

            boolean flag = true;
            for (Action x : list) {
                if (act.getMissionariesMoving() == x.getMissionariesMoving() && act.getCannibalsMoving() == x.getCannibalsMoving())
                    flag = false;
            }

            if (flag) {
                return act;
            }
        }

        return null;
    }

    @Override
    public State getResult(State state, Action action) {
        return action.move(state);
    }

    @Override
    public boolean testGoal(State state) {
        System.out.println(state.getCannibalsB() == 3 && state.getMissionariesB() == 3);
        return state.getCannibalsB() == 3 && state.getMissionariesB() == 3;
    }

    @Override
    public double getStepCosts(State state, Action action, State stateDelta) {
        return 0;
    }
}
