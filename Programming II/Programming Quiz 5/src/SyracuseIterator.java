public class SyracuseIterator extends AbstractIterator {
    private int current, seed;

    public SyracuseIterator(int seed){
        this.seed = seed;
        reset();
    }

    @Override
    public void reset() {
        current = seed * 2;
    }

    @Override
    public boolean hasNext() {
        return current != 1;
    }

    @Override
    public Object get() {
        return current;
    }

    @Override
    public Object next() {
        //even
        if(current % 2 == 0){
            current = current / 2;
        }
        //odd
        else{
            current = current * 3 + 1;
        }

        return current;
    }

    public static void main(String[] args){
        SyracuseIterator i = new SyracuseIterator(4);

        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
