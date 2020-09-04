import java.util.Scanner;

// I cannot get the first thread to notify the second
public class TwoThread {
  static Object lock = new Object();

  public static void main(String[] args) {
    Input input = new Input();
    Thread out = new Thread(new Listen(input));
    Thread in = new Thread(input);

    in.start();
    out.start();
  }
}

class Input implements Runnable {
  int value;

  @Override
  public void run() {
    while (true) {
      synchronized (TwoThread.lock) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number");
        value = in.nextInt();

        TwoThread.lock.notifyAll();
        try {
          TwoThread.lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public int getValue(){
    return value;
  }
}

class Listen implements Runnable {
  Input input;

  Listen(Input input){
    this.input = input;
  }

  @Override
  public void run() {
    try {
      while(true){
        synchronized(TwoThread.lock){
          TwoThread.lock.wait();
          int value = input.getValue();
          System.out.println(value);
        }
      }
    } catch (Exception e) {e.printStackTrace();}
  }
}