import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProjectServer {

    static class Handle extends Thread {
        Socket clientSocket;

        public void go(Socket client){
            clientSocket = client;

            this.start();
        }

        @Override
        public void run(){
            try (
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                System.out.println("Client connected on port " + clientSocket.getPort());
                while(true) {
                    String input;
                    input = in.readLine();

                    String[] list = input.split(" ");

                    try {
                        int code = Integer.parseInt(list[0]);

                        if (code == 1)
                            break;
                        else if (code == 0) {
                            int length = Integer.parseInt(list[1]);
                            String word = list[2];

                            if (checkSpelling(word))
                                out.printf("%d %d %s\n", 2, 7, "correct");
                            else
                                out.printf("%d %d %s\n", 2, 10, "misspelled");
                        }
                    }catch (NumberFormatException e) { }
                }

                System.out.println("Client on port " + clientSocket.getPort() + " closed");
            } catch (IOException e) { }
        }

        private boolean checkSpelling(String word){
            //TODO
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        int portNumber = 6969;

        ServerSocket serverSocket = new ServerSocket(portNumber);
        while(true){
                Socket clientSocket = serverSocket.accept();

                Handle h = new Handle();

                h.go(clientSocket);
        }
    }
}
