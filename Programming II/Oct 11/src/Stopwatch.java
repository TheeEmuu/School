import java.util.concurrent.TimeUnit;

public class Stopwatch {
    private Long startTime, endTime;
    private Long duration;
    private boolean running = false;

    public void start(){
        if(running)
            throw new RuntimeException  ("Stopwatch already running");
        this.running = true;
        startTime = System.nanoTime();
    }

    public Double stop(){
        this.endTime = System.nanoTime();
        if(!running){
            throw new RuntimeException("Stopwatch hasn't been started");
        }

        this.running = false;
        long result = endTime - startTime;
        if (this.duration == null)
            this.duration = result;
        else
            this.duration = duration + result;

        return duration / 1000000000.;
    }

    public void clear(){
        if (this.running)
            this.stop();

        this.duration = null;
    }
}
