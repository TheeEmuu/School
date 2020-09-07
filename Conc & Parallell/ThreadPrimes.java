import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadPrimes {
  private static boolean isPrime(int num) {
    if (num % 2 == 0)
      return false;
    else {
      for (int i = 3; i < num; i += 2) {
        if (num % i == 0)
          return false;
      }
    }

    return true;
  }

  private static List<Integer> makeList(int entries, int bound) {
    ArrayList<Integer> ret = new ArrayList<>();

    Random random = new Random();

    for (int i = 0; i < entries; i++) {
      ret.add(random.nextInt(bound) + 1);
    }

    return ret;
  }

  public static void main(String[] args) {
    int entries = 10000;
    int bound = 50000;
    List<Integer> ints = makeList(entries, bound);

    ArrayList<Integer> serialPrimes = new ArrayList<>();

    long start = System.currentTimeMillis();
    for (int x : ints) {
      if (isPrime(x))
        serialPrimes.add(x);
    }
    long end = System.currentTimeMillis();
    long serialTime = end - start;

    ArrayList<Integer> parallelPrimes = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>();

    start = System.currentTimeMillis();
    for (int x : ints) {
      threads.add(new Thread(new Runnable() {
        @Override
        public void run() {
          if (isPrime(x)) {
            parallelPrimes.add(x);
          }
        }
      }));
    }
    for (Thread x : threads) {
      x.start();
    }
    for (Thread x : threads) {
      try {
        x.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    end = System.currentTimeMillis();
    long parallelTime = end - start;

    System.out.println("Serial: " + serialTime + "ms");
    System.out.println("Parallel: " + parallelTime + "ms");
    //I expected a performace decrease, but I did not expect it to be a 30x decrease
  }
}
