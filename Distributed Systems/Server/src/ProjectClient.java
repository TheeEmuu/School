import java.net.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class ProjectClient {
    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.print("Please input the server's IP: ");
        String ip = input.next();

        try (
            Socket clientSocket = new Socket(ip, 6969);
            OutputStream out = clientSocket.getOutputStream();
            InputStream in = clientSocket.getInputStream();
        ){
            System.out.println("Type STOP to stop the program");

            while(true) {
                String stream = input.next();

                if(stream.equals("STOP"))
                    break;

                send(stream, out);

                String response = read(in);

                System.out.println(response);
            }

            out.write(new byte[]{1});
        }
        catch(IOException e){}
    }

    private static void send(String word, OutputStream out) throws IOException{
        out.write(new byte[]{0});

        out.write(ByteBuffer.allocate(4).putInt(word.length()).array());

        out.write(word.getBytes());
    }

    private static  String read(InputStream in) throws IOException{
        int code = in.read();

        if(code == 2) {
            byte[] arrr = new byte[4];
            in.read(arrr);
            int length = ByteBuffer.wrap(arrr).getInt();

            String[] arr = new String[length];

            for(int i = 0; i < length; i++){
                arr[i] = Character.toString((char)in.read());
            }

            StringBuilder build = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                build.append(arr[i]);
            }
            String word = build.toString();

            return word;
        }
        else
            return "ERROR";
    }
}
