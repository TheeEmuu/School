import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.problem.Problem;
import aima.core.search.local.HillClimbingSearch;
import aima.core.search.local.SimulatedAnnealingSearch;
import aima.core.util.datastructure.XYLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Queens implements Problem<NQueensBoard, QueenAction> {
    public static void main(String[] args) {
        Function<NQueensBoard, Double> heuristic = a -> (double)a.getNumberOfAttackingPairs();

        SimulatedAnnealing<NQueensBoard, QueenAction> search;

        search = new SimulatedAnnealing<NQueensBoard, QueenAction>(new Queens(), heuristic, .0001);

        NQueensBoard result = search.anneal();
        System.out.println(result.toString());
        System.out.println(result.getNumberOfAttackingPairs());
    }

    @Override
    public NQueensBoard getInitialState() {
        int boardSize = 8;
        NQueensBoard board = new NQueensBoard(boardSize);

        for (int i = 0; i < boardSize; i++) {
            board.addQueenAt(new XYLocation(i, new Random().nextInt(boardSize)));
        }

        return board;
    }

    @Override
    public List<QueenAction> getActions(NQueensBoard state) {
        ArrayList<QueenAction> actions = new ArrayList<>();

        for(XYLocation a : state.getQueenPositions()){
            int x = a.getX();

            for(int i = 0; i < state.getSize(); i++){
                actions.add(new QueenAction("MOVE_QUEEN", new XYLocation(x, i)));
            }
        }

        return actions;
    }

    @Override
    public NQueensBoard getResult(NQueensBoard state, QueenAction action) {
        NQueensBoard result = new NQueensBoard(state.getSize());

        result.setQueensAt(state.getQueenPositions());

        result.moveQueenTo(action.getLocation());

        return result;
    }

    @Override
    public boolean testGoal(NQueensBoard state) {
        if(state.getNumberOfAttackingPairs() == 0)
            return true;
        return false;
    }

    @Override
    public double getStepCosts(NQueensBoard state, QueenAction action, NQueensBoard stateDelta) {
        return 0;
    }
}
