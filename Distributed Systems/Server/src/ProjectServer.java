import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ProjectServer {

    static class Handle extends Thread {
        @Override
        public void run(){

        }
    }

    public static void main(String[] args) throws IOException{
        int portNumber = 6969;

        while(true){
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();

                Handle h = new Handle();

                h.start();
        }
    }
}
