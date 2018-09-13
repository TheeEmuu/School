import java.awt.Color;
/**
 * This program opens a window full of randomly colored squares.  A "disturbance"
 * moves randomly around in the window, randomly changing the color of each
 * square that it visits.  The program runs until the user closes the window.
 */

public class RandomMosaicWalk2 {

    final static int ROWS = 25;        // Number of rows in mosaic.
    final static int COLUMNS = 25;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 50; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbances in a random walk around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.setUse3DEffect(false);
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithRandomColors();
        currentRow = ROWS / 2;   // start at center of window
        currentColumn = COLUMNS / 2;
        while (Mosaic.isOpen()) {
            averageNeighbors(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(1);
        }
    }  // end main

    /**
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);  
            }
        }
    }  // end fillWithRandomColors

    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
        int green = (int)(Math.random() * 255);
        int red   = (int)(Math.random() * 255);
        int blue  = (int)(Math.random() * 255);

        Mosaic.setColor(rowNum,colNum,red,green,blue);
    }  // end changeToRandomColor

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        currentRow = (int)(Math.random() * ROWS);
        currentColumn = (int)(Math.random() * COLUMNS);
    }// end randomMove

    static void averageNeighbors(int currentRow, int currentColumn){
        int[] up    = new int[]{currentRow - 1, currentColumn};
        int[] down  = new int[]{currentRow + 1, currentColumn};
        int[] left  = new int[]{currentRow, currentColumn - 1};
        int[] right = new int[]{currentRow, currentColumn + 1};

        int[] color = new int[]{0,0,0};
        int count = 0;

        if(inBounds(up)){
            color = add(color, getColor(up));
            count++;
        }
        if(inBounds(down)){
            color = add(color, getColor(down));
            count++;
        }
        if(inBounds(left)){
            color = add(color, getColor(left));
            count++;
        }
        if(inBounds(right)){
            color = add(color,getColor(right));
            count++;
        }

        color = divide(color, count);

        Color Color = new Color(color[0],color[1],color[2]);

        Mosaic.setColor(currentRow,currentColumn, Color);
    }

    static boolean inBounds(int[] direction){
        int row = direction[0];
        int column = direction[1];

        if (row < 0 || column < 0 || row >= ROWS || column >= COLUMNS)
            return false;
        else
            return true;
    }

    static int[] getColor(int[] direction){
        int row = direction[0];
        int column = direction[1];

        int[] color = new int[3];

        color[0] = Mosaic.getRed(row,column);
        color[1] = Mosaic.getGreen(row,column);
        color[2] = Mosaic.getBlue(row, column);

        return color;
    }

    static int[] add(int[] a, int[] b){
        int[] c = new int[3];

        for(int i = 0; i < a.length; i++){
            c[i] = a[i] + b[i];
        }

        return c;
    }
    static int[] divide(int[] a, int b){
        int[] c = new int[3];

        for(int i = 0; i < a.length; i++){
            c[i] = a[i] / b;
        }

        return c;
    }
} // end class RandomMosaicWalk2
