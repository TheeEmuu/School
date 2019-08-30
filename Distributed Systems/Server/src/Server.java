import java.net.*;
import java.io.*;
import java.text.ParseException;

public class Server {
    public static void main(String[] args) throws IOException{
        int portNumber = 6666;

        while(true){
            try(
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            ){
                System.out.println("Connected");
                String input;
                input = in.readLine();
                System.out.println("-----");
                try {
                    int number = Integer.parseInt(input);
                    System.out.println(number);
                    out.println("7");
                }
                catch(NumberFormatException e){}
                System.out.println("-----");
            }
            catch(IOException e){

            }
        }
    }
}
