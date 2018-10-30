import java.util.Random;

public class RandomGenerator extends AbstractGenerator{

    private int seed;
    Random random = new Random();

    public RandomGenerator(){
        seed = (int)(Math.random() * 10000);
        reset();
    }

    public void reset(){
        random.setSeed(seed);
        set(seed);
    }

    public int next(){
        int next = random.nextInt();
        set(next);
        return next;
    }

    public static void main(String[] args){
        AbstractGenerator generator = new RandomGenerator();

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
