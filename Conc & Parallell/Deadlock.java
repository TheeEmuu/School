public class Deadlock {
  public static void main(String[] args) {
    String resource1 = "A";
    String resource2 = "B";

    Thread a = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized(resource1) {
          System.out.println("A lock 1");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        synchronized(resource2){
          System.out.println("A lock 2");
        }
      }
    });

    Thread b = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized(resource2) {
          System.out.println("B lock 2");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        synchronized(resource1){
          System.out.println("B lock 1");
        }
      }
    });

    a.start();
    b.start();
  }
}
