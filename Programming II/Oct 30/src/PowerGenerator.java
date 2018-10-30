public class PowerGenerator extends AbstractGenerator {
    public PowerGenerator(){
        reset();
    }

    public void reset(){
        set(1);
    }

    public int next() {
        int next = 2 * get();
        set(next);
        return next;
    }

    public static void main(String[] args){
        PowerGenerator generator = new PowerGenerator();

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
