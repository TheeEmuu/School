import aima.core.agent.Action;
import aima.core.environment.eightpuzzle.EightPuzzleBoard;

public class PuzzleAction {
    private String d;
    private Action act;

    public PuzzleAction(String direction){
        d = direction.toUpperCase();

        switch(d){
            case "UP":
                act = EightPuzzleBoard.UP;
                break;
            case "DOWN":
                act = EightPuzzleBoard.DOWN;
                break;
            case "LEFT":
                act = EightPuzzleBoard.LEFT;
                break;
            case "RIGHT":
                act = EightPuzzleBoard.RIGHT;
                break;
        }
    }

    public EightPuzzleBoard move(EightPuzzleBoard b){
        EightPuzzleBoard board = b.clone();

        switch(d){
            case "UP":
                board.moveGapUp();
                break;
            case "DOWN":
                board.moveGapDown();
                break;
            case "LEFT":
                board.moveGapLeft();
                break;
            case "RIGHT":
                board.moveGapRight();
                break;
        }

        return board;
    }

    public Action getAction() {
        return act;
    }
}
