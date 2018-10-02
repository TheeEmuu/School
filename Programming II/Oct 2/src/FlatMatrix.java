// An implementation of a rectangular vector.
// (c) 1998, 2001 duane a. bailey

/**
 * An implementation of rectangular vectors.
 * This implementation of a Matrix is minimal.  Few operations
 * are provided, and no support for mathematical operations
 * is considered.
 *
 * @version $Id: Matrix.java 31 2007-08-06 17:19:56Z bailey $
 * @author, 2001 duane a. bailey
 */
public class FlatMatrix<E> {
    protected int height, width; // size of matrix
    protected Vector<E> matrix;       // vector of row vectors

    /**
     * Construct an empty matrix.
     *
     * @post constructs empty matrix<br>
     *
     */
    public Matrix()
    {
        this(0,0);
    }

    /**
     * Constructs a matrix such that all values are null.
     *
     * @pre h >= 0, w >= 0;<br>
     * @post constructs an h row by w column matrix<br>
     *
     * @param h Height of the matrix.
     * @param w Width of the matrix.
     */
    public Matrix(int h, int w)
    {
        height = h;
        width = w;

        matrix = new Vector<E>(width * height, 0, null);
//        height = h;  // initialize height and width
//        width = w;
//        // allocate a vector of rows
//        rows = new Vector<Vector<E>>(height, 0, null);
//        for (int r = 0; r < height; r++)
//        {   // each row is allocated and filled with nulls
//            Vector<E> theRow = new Vector<E>(width, 0, null);
//            rows.add(theRow);
//            for (int c = 0; c < width; c++)
//            {
//                theRow.add(null);
//            }
//        }
    }

    /**
     * Fetch an element from the matrix.
     * @pre 0 <= row < height(), 0 <= col < width()<br>
     * @post returns object at (row, col)<br>
     *
     * @param row The row of the element
     * @param col The column of the element
     * @return Object located at matrix position (row, col)
     */
    public E get(int row, int col)
    {
        Vector<E> theRow = rows.get(row);
        return theRow.get(col);
    }

    /**
     * Change the value at location (row, col)
     * @pre 0 <= row < height(), 0 <= col < width()<br>
     * @post changes location (row, col) to value<br>
     *
     * @param value The new Object reference (possibly null).
     * @param row The row of the value to be changed.
     * @param col The column of the value to be changed.
     */
    public void set(int row, int col, E value)
    {
        Vector<E> theRow = rows.get(row);
        theRow.set(col, value);
    }

    /**
     * Add a new row, whose index will be r.
     *
     * @pre 0 <= r < height()<br>
     * @post inserts row of null values to be row r<br>
     *
     * @param r The index of the  newly inserted row.
     */
    public void addRow(int r)
    {
        height++;
        Vector<E> theRow = new Vector<E>(width, 0, null);
        for (int c = 0; c < width; c++)
        {
            theRow.add(null);
        }
        rows.add(r,theRow);
    }

    /**
     * Add a new column, whose index will be c.
     *
     * @pre 0 <= c < width()<br>
     * @post inserts column of null values to be column c<br>
     *
     * @param c The index of the newly inserted column.
     */
    public void addCol(int c)
    {
        width++;
        for (int r = 0; r < height; r++)
        {
            Vector<E> theRow = rows.get(r);
            theRow.add(c,null);
        }
    }

    /**
     * Remove the row whose index is r.
     * The row is returned as a vector.
     * @pre 0 <= r < height()<br>
     * @post removes row r and returns it as a Vector
     *
     * @param r The index of the to-be-removed row.
     * @return A vector of values once in the row.
     */
    public Vector<E> removeRow(int r)
    {
        Vector<E> result = rows.get(r);
        height--;
        rows.remove(r);
        return result;
    }

    /**
     * Remove a column, whose index is c.
     * @pre 0 <= c < width()<br>
     * @post removes column c and returns it as a vector<br>
     *
     * @param c The index of the column to be removed.
     * @return A vector of the values removed.
     */
    public Vector<E> removeCol(int c)
    {
        Vector<E> result = new Vector<E>(height, 0, null);
        width--;
        for (int r = 0; r < height; r++)
        {
            Vector<E> theRow = rows.get(r);
            result.add(theRow.get(c));
            theRow.remove(c);
        }
        return result;
    }

    /**
     * Return the width of the matrix.
     * @post returns number of columns in matrix<br>
     *
     * @return The number of columns in the matrix.
     */
    public int width()
    {
        return width;
    }

    /**
     * Return the height of the matrix.
     *
     * @post returns number of rows in matrix<br>
     *
     * @return The number of rows in the matrix.
     */
    public int height()
    {
        return height;
    }

    /**
     * Construct a string representation of the matrix.
     * @post returns string description of matrix.<br>
     *
     * @return A string, representing the matrix.
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Matrix:\n");
        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                s.append("  <Row "+r+", Col "+c+", value=");
                s.append(get(r,c)+">");
            }
            s.append("\n");
        }
        s.append(">");
        return s.toString();
    }

    public Matrix<E> transpose(){
        Matrix<E> m = new Matrix<E>(width, height);

        for(int i = 0; i < width; i++){
            for(int k = 0; k < height; k++){
                m.set(i,k,this.get(k,i));
            }
        }

        return m;
    }
}