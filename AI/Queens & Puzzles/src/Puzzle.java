import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.problem.Problem;
import aima.core.util.datastructure.XYLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Puzzle implements Problem<EightPuzzleBoard, PuzzleAction> {
    public static void main(String[] args){
        Function<EightPuzzleBoard, Double> heuristic = a -> (double)totalManhattan(a);

        SimulatedAnnealing<EightPuzzleBoard, PuzzleAction> search;

        int correct = 0;
        for(int i = 0; i < 100; i++){
            search = new SimulatedAnnealing<EightPuzzleBoard, PuzzleAction>(new Puzzle(), heuristic, .000005);
            if(totalManhattan(search.anneal()) == 0)
                correct++;
        }

        System.out.println(correct);
    }

    @Override
    public EightPuzzleBoard getInitialState() {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        EightPuzzleBoard board = new EightPuzzleBoard(a);

        String[] dir = new String[]{"UP", "DOWN", "LEFT", "RIGHT"};

        Random random = new Random();
        for(int i = 0; i < 200; i++){
            String direction = dir[random.nextInt(4)];
            PuzzleAction act = new PuzzleAction(direction);
            board = act.move(board);
        }

        return board;
    }

    @Override
    public List<PuzzleAction> getActions(EightPuzzleBoard state) {
        List<PuzzleAction> list = new ArrayList<>();
        String[] dir = new String[]{"UP", "DOWN", "LEFT", "RIGHT"};

        for(String x : dir){
            PuzzleAction act = new PuzzleAction(x);
            if(state.canMoveGap(act.getAction()))
                list.add(act);
        }

        return list;
    }

    @Override
    public EightPuzzleBoard getResult(EightPuzzleBoard state, PuzzleAction action) {
        return action.move(state.clone());
    }

    @Override
    public boolean testGoal(EightPuzzleBoard state) {
        boolean result = true;
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++) {
                if (state.getValueAt(new XYLocation(i, k)) != i)
                    result = false;
            }
        }

        return result;
    }

    @Override
    public double getStepCosts(EightPuzzleBoard state, PuzzleAction action, EightPuzzleBoard stateDelta) {
        return 0;
    }

    public static int totalManhattan(EightPuzzleBoard board){
        int totalDistance = 0;

        // 0 1 2
        // 3 4 5
        // 6 7 8
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                int cur = board.getValueAt(new XYLocation(k, i));

                int x = cur % 3;
                int y = (cur - x) / 3;

                totalDistance += Math.abs(k - x) + Math.abs(i - y);
            }
        }

        return totalDistance;
    }
}
