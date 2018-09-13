/** 
 * An object of class StatCalc can be used to compute several simple statistics
 * for a set of numbers.  Numbers are entered into the dataset using
 * the enter(double) method.  Methods are provided to return the following
 * statistics for the set of numbers that have been entered: The number
 * of items, the sum of the items, the average, and the standard deviation
 */

public class StatCalc {

    private int count;   // Number of numbers that have been entered.
    private double sum;  // The sum of all the items that have been entered.
    private double squareSum;  // The sum of the squares of all the items.
    private double min;
    private double max;
    double[] tempList;
    double [] list =  new double[0];

    /**
     * Add a number to the dataset.  The statistics will be computed for all
     * the numbers that have been added to the dataset using this method.
     */
    public void enter(double num) {
        count++;
        sum += num;
        squareSum += num*num;

        tempList = list;
        list = new double[count];

        for(int i = 0; i < tempList.length; i++){
            list[i] = tempList[i];
        }
        list[count] = num;

        if (num < min)
            min = num;
        if (num > max)
            max = num;
    }

    /**
     * Return the number of items that have been entered into the dataset.
     */
    public int getCount() {
        return count;
    }

    /**
     * Return the sum of all the numbers that have been entered.
     */
    public double getSum() {
        return sum;
    }

    /**
     * Return the average of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getMean() {
        return sum / count;  
    }

    public double getMax(){ return max; }

    public double getMin(){ return min; }

    /**
     * Return the standard deviation of all the items that have been entered.
     * The return value is Double.NaN if no numbers have been entered.
     */
    public double getStandardDeviation() {  
        double mean = getMean();
        return Math.sqrt( squareSum/count - mean*mean );
    }

    public double getMedian(){
        double median;
        double halfCount = count/2.0;

        if(count%2 == 0){
            median = (list[(int)(halfCount)] -list[(int)(halfCount + 1)])/2;
        }
        else
            median = list[(int)(halfCount + 0.5)];

        return median;
    }

}  // end class StatCalc
