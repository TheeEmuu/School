using System;

class Program{
    static void Main(String[] args){
        Counter c = new Counter(20);
        c.ThresholdReached += c_ThresholdReached;

        while(true){
            c.Add(1);
        }
    }

    static void c_ThresholdReached(object sender, ThresholdReachedEventArgs e){
        Console.WriteLine("The threshold of {0} was reached at {1}.", e.Threshold, e.TimeReached);
        Environment.Exit(0);
    }
}

class Counter{
    private int threshold;
    private int total;

    public Counter(int passedThreshold){
        threshold = passedThreshold;
    }

    public void Add(int x){
        total += x;

        if(total >= threshold){
            ThresholdReachedEventArgs args = new ThresholdReachedEventArgs();
            args.Threshold = threshold;
            args.TimeReached = DateTime.Now;
            OnThresholdReached(args);
        }
    }

    protected virtual void OnThresholdReached(ThresholdReachedEventArgs e){
        EventHandler<ThresholdReachedEventArgs> handler = ThresholdReached;
        if(handler != null)
            handler(this, e);
    }

    public event EventHandler<ThresholdReachedEventArgs> ThresholdReached;
}

public class ThresholdReachedEventArgs : EventArgs{
    public int Threshold { get; set; }
    public DateTime TimeReached { get; set; }
}