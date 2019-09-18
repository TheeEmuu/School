import aima.core.search.framework.problem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class SimulatedAnnealing<S, A> {

    private static double T = 1;
    private static final double Tmin = .0001;
    private static final double alpha = 0.9;
    private static final int numIterations = 100;

    private Problem<S, A> problem;
    Function<S, Double> energy;

    Random random = new Random();

    List<S> states;
    List<A> actions;

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic){
        actions = new ArrayList<>();
        states = new ArrayList<>();
        energy = heuristic;

        S currentState = p.getInitialState();

        while(!p.testGoal(currentState)) {
            List<A> availableActions = p.getActions(currentState);

            ArrayList<S> potentialStates = new ArrayList<>();
            for(A x : availableActions){
                potentialStates.add(p.getResult(currentState, x));
            }

            int desired = anneal(currentState, potentialStates);

            actions.add(availableActions.get(desired));
            states.add(potentialStates.get(desired));
            currentState = potentialStates.get(desired);
        }
    }

    private int anneal(S currentState, List<S> potentialStates){
        int currentBest = -1;
        Double min = energy.apply(currentState);
        Random neighborFunction = new Random();
        int neighbor = -1;

        while(T > Tmin){
            for(int i = 0; i < numIterations; i++) {
                if(energy.apply(currentState) < min){
                    min = energy.apply(currentState);
                    currentBest = neighbor;
                }

                neighbor = neighborFunction.nextInt(potentialStates.size());

//                double prob = Math.pow(Math.E, energy.apply(currentState) - energy.apply(potentialStates.get(neighbor)));
                double prob = 0;

                if(prob > Math.random()) {
                    currentBest = neighbor;
                    currentState = potentialStates.get(neighbor);
                }
            }

            T = T - alpha;
        }

        return currentBest;
    }

    public List<S> getStates() {
        return states;
    }

    public List<A> getActions() {
        return actions;
    }
}
