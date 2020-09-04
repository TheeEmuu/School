import java.util.Scanner;

// I cannot get the first thread to notify the second
public class TwoThread {

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
    while(true){
      synchronized(this){
        Scanner in = new Scanner(System.in);
        System.out.println("Input a number");
        value = in.nextInt();

        this.notify();
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
        synchronized(input){
          input.wait();
          int value = input.getValue();
          System.out.println(value);
        }
      }
    } catch (Exception e) {e.printStackTrace();}
  }
}