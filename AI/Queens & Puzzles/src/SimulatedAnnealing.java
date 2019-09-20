import aima.core.search.framework.problem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class SimulatedAnnealing<S, A> {

    private static double T = 1;
    private static final double Tmin = .0001;
    private static double alpha;
    private static final int numIterations = 500;

    private Problem<S, A> problem;
    S initialState;
    Function<S, Double> energy;

    Random random = new Random();

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic, S init, double schedule){
        problem = p;
        energy = heuristic;
        initialState = init;
        T = 1;
        alpha = schedule;
    }

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic, double schedule){
        this(p, heuristic, p.getInitialState(), schedule);
    }

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic, S init){
        this(p, heuristic, init, .0001);
    }

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic){
        this(p, heuristic, p.getInitialState(), .0001);
    }

    public S anneal(){
        S currentState = initialState;
        S bestState = currentState;

        while(T > Tmin){
            // Debug steps : System.out.println(energy.apply(currentState) + " " + energy.apply(bestState));
            for(int i = 0; i < numIterations; i++){
                if(energy.apply(currentState) < energy.apply(bestState)) {
                    bestState = currentState;
                }

                S neighbor = neighbor(currentState);
                if(Math.exp((energy.apply(currentState) - energy.apply(neighbor)) / T) > Math.random())
                    currentState = neighbor;

                T -= alpha;
            }
        }

        return bestState;
    }

//    private int anneal(S currentState, List<S> potentialStates){
//        int currentBest = -1;
//        Double min = energy.apply(currentState);
//        Random neighborFunction = new Random();
//        int neighbor = -1;
//
//        while(T > Tmin){
//            for(int i = 0; i < numIterations; i++) {
//                if(energy.apply(currentState) < min){
//                    min = energy.apply(currentState);
//                    currentBest = neighbor;
//                }
//
//                neighbor = neighborFunction.nextInt(potentialStates.size());
//
//                double prob = Math.pow(Math.E, energy.apply(currentState) - energy.apply(potentialStates.get(neighbor)));
//
//                if(prob > Math.random()) {
//                    currentBest = neighbor;
//                    currentState = potentialStates.get(neighbor);
//                }
//            }
//
//            T = T - alpha;
//        }
//
//        return currentBest;
//    }

    private S neighbor(S currentState){
        List<A> availableActions = problem.getActions(currentState);
        return problem.getResult(currentState, availableActions.get(random.nextInt(availableActions.size())));
    }
}
