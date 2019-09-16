import aima.core.environment.eightpuzzle.EightPuzzleBoard;
import aima.core.search.framework.problem.Problem;

import java.util.List;

public class Puzzle implements Problem<EightPuzzleBoard, PuzzleAction> {
    public static void main(String[] args){
        EightPuzzleBoard puzzle = new EightPuzzleBoard();

        System.out.println(puzzle.toString());
    }

    @Override
    public EightPuzzleBoard getInitialState() {

    }

    @Override
    public List<PuzzleAction> getActions(EightPuzzleBoard state) {
        return null;
    }

    @Override
    public EightPuzzleBoard getResult(EightPuzzleBoard state, PuzzleAction action) {
        return null;
    }

    @Override
    public boolean testGoal(EightPuzzleBoard state) {
        return false;
    }

    @Override
    public double getStepCosts(EightPuzzleBoard state, PuzzleAction action, EightPuzzleBoard stateDelta) {
        return 0;
    }
}
