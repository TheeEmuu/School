import java.util.ArrayList;
import java.util.List;

public class Threading {
  public static void main(String[] args) throws InterruptedException {
    Thread a = new Thread(new Run(20));
    Thread b = new Thread(new Run(15));
    Thread c = new Thread(new Run(50));
    a.start();
    b.start();
    c.start();
    b.join();
    c.interrupt();

    List<String> list = new ArrayList<String>();
    Thread ls1 = new Thread(new Lister(list));
    Thread ls2 = new Thread(new Lister(list));
    ls1.start();
    ls2.start();

    ls1.join();
    ls2.join();

    for (String string : list) {
      System.out.println(string);
    }
  }
}

class Run implements Runnable {
  int itt;

  Run(int num) {
    itt = num;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < itt; i++) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + i);
        Thread.sleep(500);
      }
    } catch (Exception e) {
      String name = Thread.currentThread().getName();
      System.out.println(name + ": Interrupted");
    }
  }
}

class Lister implements Runnable {
  List<String> list;

  Lister(List<String> ls) {
    list = ls;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 20; i++) {
        String name = Thread.currentThread().getName();
        list.add(name + ": " + i);
      }
    } catch (Exception e) {
      String name = Thread.currentThread().getName();
      list.add(name + ": Interrupted");
    }
  }
}