import aima.core.search.framework.problem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class SimulatedAnnealing<S, A> {

    private double T = 1;
    private final double Tmin = .00001;
    private double alpha;
    private final int numIterations = 500;

    private Problem<S, A> problem;
    S initialState;
    Function<S, Double> energy;

    Random random = new Random();

    public SimulatedAnnealing(Problem<S, A> p, Function<S, Double> heuristic, S init, double schedule){
        problem = p;
        energy = heuristic;
        initialState = init;
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
        while (T > Tmin) {
//            System.out.println(energy.apply(currentState) + " " + energy.apply(bestState));
            for (int i = 0; i < numIterations; i++) {
                if (energy.apply(currentState) < energy.apply(bestState)) {
                    bestState = currentState;
                }

                S neighbor = neighbor(currentState);
                if (Math.exp((energy.apply(currentState) - energy.apply(neighbor)) / T) > Math.random())
                    currentState = neighbor;

                T -= alpha;
            }
        }


        return bestState;
    }

    private S neighbor(S currentState){
        List<A> availableActions = problem.getActions(currentState);
        return problem.getResult(currentState, availableActions.get(random.nextInt(availableActions.size())));
    }
}
