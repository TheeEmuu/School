public class Stopwatch {
    //region Variables
    protected long startTime;
    protected long stopTime;
    protected long totalTime;
    //endregion

    //region Constructors
    public Stopwatch(){
        startTime = 0;
        stopTime = 0;
        totalTime = 0;
    }
    //endregion

    //region Commands
    public void start(){
        startTime = System.nanoTime();
    }

    public void stop(){
        stopTime = System.nanoTime();
        addTime();
    }

    public void reset(){
        totalTime = 0;
    }
    //endregion

    //region Accessors
    public double getTime(){
        return totalTime;
    }
    //endregion

    protected void addTime(){
        totalTime = stopTime - startTime;
    }
}
