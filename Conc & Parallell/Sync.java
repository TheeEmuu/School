import java.util.Scanner;

class Sync {
  private int value;

  public Sync(){
    value = 42;
  }

  public void update(){

  }

  public void get() {

  }
}

public class Proggy {
  private static Sync s = new Sync();

  public static void getValue(){
    Scanner in = new Scanner(System.in);
    while(true){
      System.out.println("Giff value");
      s.update(in.nextInt());
    }
  }

  public static void printValue(){

  }

  public static void main(String[] args) {
    Thread th1 = new Thread(() -> {getValue();});
    Thread th2 = new Thread(() -> {printValue();});

    th1.start();
    th2.start();

    th1.join();
    th2.join();
  }
}