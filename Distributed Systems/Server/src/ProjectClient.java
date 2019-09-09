import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ProjectClient {
    public static void main(String[] args) throws  IOException{
        try (
            Socket clientSocket = new Socket("127.0.0.1", 6969);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            Scanner input = new Scanner(System.in);
            System.out.println("Type STOP to stop the program");

            while(true) {
                String stream = input.next();

                if(stream.equals("STOP"))
                    break;
                out.printf("%d %d %s\n", 0, stream.length(), stream);

                String response = in.readLine();
                response = response.split(" ")[2];
                System.out.println(response);
            }

            out.println("1\n");
        }
        catch(IOException e){}
    }
}
