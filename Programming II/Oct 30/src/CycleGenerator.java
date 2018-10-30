public class CycleGenerator extends AbstractGenerator {
    int start, end;

    public CycleGenerator(int start, int end){
        this.start = start;
        this.end = end;
        reset();
    }

    public void reset(){
        set(start);
    }

    public int next(){
        int next = get() + 1;
        if (next > end){
            reset();
            next = get();
        }

        set(next);
        return next;
    }

    public static void main(String[] args){
        AbstractGenerator generator = new CycleGenerator(10,12);

        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());

        generator.reset();

        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());
        generator.next();
        System.out.println(generator.get());
    }
}
