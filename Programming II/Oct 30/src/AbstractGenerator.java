abstract public class AbstractGenerator implements Generator {
    protected int current; // the last value saved

    // post: initialize the current value to initial
    public AbstractGenerator(int initial){
        current = initial;
    }

    // post: initialize the current value to zero
    public AbstractGenerator(){
        this(0);
    }

    // post: sets the current value to next, and extends the sequence
    protected int set(Integer next){
        int result = current;
        current = next;
        return result;
    }

    // post: returns the current value of the sequence
    public int get(){
        return current;
    }

    // post: resets the Generator (by default, does nothing)
    public void reset() { }
}
